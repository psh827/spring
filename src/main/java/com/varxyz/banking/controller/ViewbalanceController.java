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
public class ViewbalanceController {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@GetMapping("/account/view_balance")
	public String viewBalanceForm(HttpSession session,  HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "http://localhost:8080/banking/login_add/login");
			return "alert";
		}
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);
		return "account/view_balance";
	}
	
	@PostMapping("/account/view_balance")
	public String viewBalance(HttpSession session, HttpServletRequest request) {
		String accountNum = request.getParameter("accountNum");
		double balance = accountService.getBalance(accountNum);
		
		request.setAttribute("accountNum", accountNum);
		request.setAttribute("balance", balance);
		
		return "account/view_balance_info";
		
		
	}
}
