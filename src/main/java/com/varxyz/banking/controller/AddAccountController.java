package com.varxyz.banking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.SavingAccount;
import com.varxyz.banking.service.AccountServiceImpl;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class AddAccountController {
	
	@Autowired
	AccountServiceImpl accountService;
	
	@Autowired
	CustomerServiceImpl customerService;
	
	/**
	 * 계좌 신청에 대한 페이지
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/account/add_account")
	public String addAccountForm(HttpSession session,  HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		//로그인 안했으면 돌아가기
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "http://localhost:8080/banking/login_add/login");
			return "alert";
		}
		return "account/add_account";
	}
	
	@PostMapping("/account/add_account")
	public String addAccount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//필요한 데이터 저장
		String userId = (String)session.getAttribute("userId");
		String accTypeString = request.getParameter("accType"); 
		char accType = accTypeString.charAt(0);
		Account account = null;
		
		//오류검색
		if(accType != 'S' && accType != 'C' || accTypeString.length() >= 2) {
			request.setAttribute("msg", "잘못된 입력입니다. S, C 만 입력가능합니다.");
			request.setAttribute("url", "add_account");
			return "alert";
		}
		
		//들어온 데이터에 따른 객체 생성
		if(accType == 'S') {
			account = new SavingAccount();
		}else if (accType == 'C') {
			account = new CheckingAccount();
		}
		
		//랜덤 계좌 생성
		account.setAccountNum(generateAccount());
		account.setCustomer(customerService.getCustomerByUserId(userId));
		account.setAccType(accType);
		accountService.addAccounts(account);
		request.setAttribute("accType", account.getAccountNum());
		return "account/add_success_account";
			
	}
	
	/**
	 * XXX-XX-XXXX 형식의 계좌번호 생성.
	 * 
	 * @return
	 */
	public String generateAccount() {
		String numStr = String.valueOf((int)(Math.random() * 100000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		
		return sb.toString();
	}
}
