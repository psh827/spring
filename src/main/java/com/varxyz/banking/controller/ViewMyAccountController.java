package com.varxyz.banking.controller;

import java.io.PrintWriter;
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
public class ViewMyAccountController {
	@Autowired
	private AccountServiceImpl accountService;
	
	
	@GetMapping("/account/view_my_accounts")
	public String viewMyAccountForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/login_add/login");
			return "alert";
		}
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);
		return "account/view_my_accounts";
	}
}
