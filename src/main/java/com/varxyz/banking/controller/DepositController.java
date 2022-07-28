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
	
	@GetMapping("/account/deposit")
	public String depositForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "http://localhost:8080/banking/login_add/login");
			return "alert";
		}
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);
		return "account/deposit";
	}
	
	@PostMapping("/account/deposit")
	public String deposit(HttpSession session, HttpServletRequest request) {
		String accountNum = request.getParameter("accountNum");
		String depositMoneyStr = request.getParameter("depositMoney").replace(",", "");
		if(depositMoneyStr.matches(".*[a-zA-Z].*") || depositMoneyStr.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			request.setAttribute("msg", "금액 입력이 잘못되었습니다. 숫자만 가능합니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}
		double depositMoney = Double.parseDouble(depositMoneyStr);
		
		if(depositMoney < 0.0) {
			request.setAttribute("msg", "잘못된 입력입니다.");
			request.setAttribute("url", "deposit");
			return "alert";
		}


		accountService.deposit(depositMoney, accountNum);
		request.setAttribute("accountNum", accountNum);
		request.setAttribute("depositMoney", depositMoney);
		return "account/deposit_success";
		
	}
}
