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
	
	/**
	 * 계좌별 잔액 조회
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/account/view_balance")
	public String viewBalanceForm(HttpSession session,  HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		//로그인이 안되어있을 시
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "http://localhost:8080/banking/login_add/login");
			return "alert";
		}
		//화면에 선택할 계좌를 위한 데이터를 전달해 준다.
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);
		return "account/view_balance";
	}
	
	/**
	 * 계좌별 잔액 조회 세부
	 * @param session
	 * @param request
	 * @return
	 */
	@PostMapping("/account/view_balance")
	public String viewBalance(HttpSession session, HttpServletRequest request) {
		//계좌번호를 저장하고.
		String accountNum = request.getParameter("accountNum");
		//그 계좌의 잔액을 저장.
		int balance = (int) accountService.getBalance(accountNum);
		
		
		request.setAttribute("accountNum", accountNum);
		request.setAttribute("balance", balance);
		
		return "account/view_balance_info";
	}
	
}
