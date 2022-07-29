package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.service.AccountServiceImpl;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class TransferController {
	
	@Autowired
	AccountServiceImpl accountService;
	
	@Autowired
	CustomerServiceImpl customerService;
	
	/**
	 * 이체 화면
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/account/transfer")
	public String transferForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		//세션확인
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/banking/login_add/login");
			return "alert";
		}
		
		//내계좌 전송
		List<Account> myAccountList = accountService.getAccounts(userId);
		request.setAttribute("myAccountList", myAccountList);
		
		return "account/transfer";
	}
	
	/**
	 * 보내는계좌, 금액, 받는계좌
	 * @param request
	 * @param session
	 * @return
	 */
	@PostMapping("/account/transfer")
	public String transfer(HttpServletRequest request, HttpSession session) {
		
		String withdrawAccountNum = request.getParameter("withdrawAccountNum");
		
		//금액에대한 데이터 저장
		String sendMoneyStr = request.getParameter("sendMoney");
		//금액에 숫자 이외의 값은 못들어오게 만들기
		if(sendMoneyStr.matches(".*[a-zA-Z].*") || sendMoneyStr.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			request.setAttribute("msg", "금액 입력이 잘못되었습니다. 숫자만 가능합니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}
		//받는계좌
		String depositAccountNum = request.getParameter("depositAccountNum");
		Customer customer = customerService.getCustomerByAccountNum(depositAccountNum);
		//받는계좌의 사람이 없으면 alert창 띄운 후 페이지 이동
		if(customer == null) {
			request.setAttribute("msg", "계좌번호를 잘못 입력하셨습니다. 확인해 주세요");
			request.setAttribute("url", "transfer");
			return "alert";
		}
		
		Customer myCustomer = customerService.getCustomerByAccountNum(withdrawAccountNum);
		
		/**
		 * 세션을 사용한 이유.
		 * 세션을 이용해서 계좌이체 시작부터 마지막까지 정보들을 다 유지하고 싶었음.
		 * transferCommand를 이용하면 코드 가독성이 더 좋아질 것이라 생각.
		 */
		session.setAttribute("withdrawAccountNum", withdrawAccountNum);
		session.setAttribute("receiveName", customer.getName());
		session.setAttribute("depositAccountNum", depositAccountNum);
		session.setAttribute("passwd", myCustomer.getPasswd());
		session.setAttribute("sendMoney", sendMoneyStr);
		
		return "account/transferAlertBefore";
	}

	/**
	 * 이체가 성공한 후 화면
	 * @param session
	 * @param request
	 * @return
	 */
	@PostMapping("/account/transfer_success")
	public String transferSuccess(HttpSession session, HttpServletRequest request) {
		
		//성공화면에 띄울 데이터들을 저장
		String withdrawAccountNum = (String)session.getAttribute("withdrawAccountNum");
		String sendMoneyStr = (String)session.getAttribute("sendMoney"); //돈을 ,처리 지수제거 하기 위해 String으로 받아온다.
		String depositAccountNum = (String)session.getAttribute("depositAccountNum");
		double withdrawBalance = accountService.getBalance(withdrawAccountNum);
		String checkPasswd = (String)session.getAttribute("passwd"); //내 비밀번호를 알아야하기 때문에 받아온다.
		String passwd = request.getParameter("passwd");
		
		
		//이것은 주소로 들어갔을때 혹은 뒤로가기로 했을때 화면에 접근을 할 수 없게 만들기.
		if(withdrawBalance == 0 || sendMoneyStr == null) {
			request.setAttribute("msg", "접근방식이 잘못되었습니다.");
			request.setAttribute("url", "transfer");
			
			return "alert";
		}
		
		//보내는 돈에 대한 데이터 저장.
		double sendMoney = Double.parseDouble(sendMoneyStr.replace(",", ""));
		request.setAttribute("sendMoney", sendMoneyStr);
		
		//비밀 번호가 같지 않다면 alert창으로 보내기 그리고 모든 세션 종료
		if(!checkPasswd.equals(passwd)) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			request.setAttribute("url", "transfer");
			
			session.removeAttribute("withdrawAccountNum");
			session.removeAttribute("receiveName");
			session.removeAttribute("depositAccountNum");
			session.removeAttribute("passwd");
			session.removeAttribute("sendMoney");
			
		    return "alert";
		}
		
		//잔액이 부족하다면 alert창으로 보내기 그리고 모든 세션 종료
		if(withdrawBalance - sendMoney < 0) {
			request.setAttribute("msg", "잔액이 부족합니다.");
			request.setAttribute("url", "transfer");
			
			session.removeAttribute("withdrawAccountNum");
			session.removeAttribute("receiveName");
			session.removeAttribute("depositAccountNum");
			session.removeAttribute("passwd");
			session.removeAttribute("sendMoney");
			
			return "alert";
		}
		
		//모든 검사가 성공했다면 쿼리문을 실행한다.
		accountService.transfer(sendMoney, withdrawAccountNum, depositAccountNum);
		
		//보내고 난후 나의 잔액을 확인하기 위한 쿼리
		double afterTransfer = accountService.getBalance(withdrawAccountNum);
		
		//화면에 띄울 데이터를 모두 보내기
		request.setAttribute("msg", "송금이 완료되었습니다.");
		request.setAttribute("url", "/banking/main");
		request.setAttribute("afterTransferMoney", (int)afterTransfer);
		request.setAttribute("receiveName", session.getAttribute("receiveName"));
		
		//이체에 필요했던 session을 전부 제거한다.
		session.removeAttribute("withdrawAccountNum");
		session.removeAttribute("receiveName");
		session.removeAttribute("depositAccountNum");
		session.removeAttribute("passwd");
		session.removeAttribute("sendMoney");
		
		return "account/transfer_success";
	}
	
}

