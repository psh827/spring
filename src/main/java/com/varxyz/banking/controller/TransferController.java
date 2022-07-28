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
	
	@GetMapping("/account/transfer")
	public String transferForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/banking/login_add/login");
			return "alert";
		}
		List<Account> myAccountList = accountService.getAccounts(userId);
		request.setAttribute("myAccountList", myAccountList);
		return "account/transfer";
	}
	
	@PostMapping("/account/transfer")
	public String transfer(HttpServletRequest request, HttpSession session) {
		String withdrawAccountNum = request.getParameter("withdrawAccountNum");
		String sendMoneyStr = request.getParameter("sendMoney");
		if(sendMoneyStr.matches(".*[a-zA-Z].*") || sendMoneyStr.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			request.setAttribute("msg", "금액 입력이 잘못되었습니다. 숫자만 가능합니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}
		
		String depositAccountNum = request.getParameter("depositAccountNum");
		
		
		Customer customer = customerService.getCustomerByAccountNum(depositAccountNum);
		if(customer == null) {
			request.setAttribute("msg", "계좌번호를 잘못 입력하셨습니다. 확인해 주세요");
			request.setAttribute("url", "transfer");
			return "alert";
		}
		
		Customer myCustomer = customerService.getCustomerByAccountNum(withdrawAccountNum);
		
		session = request.getSession();
		session.setAttribute("withdrawAccountNum", withdrawAccountNum);
		session.setAttribute("receiveName", customer.getName());
		session.setAttribute("depositAccountNum", depositAccountNum);
		session.setAttribute("passwd", myCustomer.getPasswd());
		session.setAttribute("sendMoney", sendMoneyStr);
		
		return "account/transferAlertBefore";
	}

	
	@PostMapping("/account/transfer_success")
	public String transferSuccess(HttpSession session, HttpServletRequest request) {
		
		String withdrawAccountNum = (String)session.getAttribute("withdrawAccountNum");
		String sendMoneyStr = (String)session.getAttribute("sendMoney");
		String depositAccountNum = (String)session.getAttribute("depositAccountNum");
		double withdrawBalance = accountService.getBalance(withdrawAccountNum);
		String checkPasswd = (String)session.getAttribute("passwd");
		String passwd = request.getParameter("passwd");
		
		
		request.setAttribute("sendMoney", sendMoneyStr);
		double sendMoney = Double.parseDouble(sendMoneyStr.replace(",", ""));
				
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
		
		accountService.transfer(sendMoney, withdrawAccountNum, depositAccountNum);
		
		double afterTransfer = accountService.getBalance(withdrawAccountNum);
		
		request.setAttribute("msg", "송금이 완료되었습니다.");
		request.setAttribute("url", "/banking/main");
		request.setAttribute("afterTransferMoney", afterTransfer);
		request.setAttribute("receiveName", session.getAttribute("receiveName"));
		
		session.removeAttribute("withdrawAccountNum");
		session.removeAttribute("receiveName");
		session.removeAttribute("depositAccountNum");
		session.removeAttribute("passwd");
		session.removeAttribute("sendMoney");
		
		return "account/transfer_success";
	}
	
}

