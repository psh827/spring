package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.service.AccountServiceImpl;

@Controller
public class DepositController {

	@Autowired
	private AccountServiceImpl accountService;
	
	/**
	 * 입금 페이지
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/account/deposit")
	public String depositForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		//로그인이 되어있지 않다면 돌아가기
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "http://localhost:8080/banking/login_add/login");
			return "alert";
		}
		//입금시 원하는계좌를 선택해야하니 거기에 맞는 데이터 저장 후 보내기
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);
		return "account/deposit";
	}
	
	@PostMapping("/account/deposit")
	public String deposit(HttpSession session, HttpServletRequest request) {
		String accountNum = request.getParameter("accountNum");
	
		String depositMoneyStr = request.getParameter("depositMoney").replace(",", "");
		
		//숫자 이외의 금액이 들어왔을시 처리
		if(depositMoneyStr.matches(".*[a-zA-Z].*") || depositMoneyStr.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			request.setAttribute("msg", "금액 입력이 잘못되었습니다. 숫자만 가능합니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}
		
		//받은 데이터를 double형으로 변환
		double depositMoney = Double.parseDouble(depositMoneyStr);
		
		//금액이 0원 이하일 때의 오류처리
		if(depositMoney < 0.0) {
			request.setAttribute("msg", "잘못된 입력입니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}

		//쿼리문 실행
		accountService.deposit(depositMoney, accountNum);
		//다음 화면에 보일 데이터 넘기기
		request.setAttribute("accountNum", accountNum);
		request.setAttribute("depositMoney", (int)depositMoney);
		return "account/deposit_success";
		
	}
}
