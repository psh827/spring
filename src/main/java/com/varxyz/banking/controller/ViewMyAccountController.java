package com.varxyz.banking.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.service.AccountServiceImpl;

@Controller
public class ViewMyAccountController {
	@Autowired
	private AccountServiceImpl accountService;
	
	/**
	 * 전체 계좌 조회
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/account/view_my_accounts")
	public String viewMyAccountForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		//로그인이 되어 있지 않다면 돌아가기
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "http://localhost:8080/banking/login_add/login");
			return "alert";
		}
		
		//계좌리스트와 계좌별 잔액 리스트. double형이라서 지수 제거를 위해 두개 만들었다.
		//더좋은 방법도 찾아봐야 함.
		List<Account> accountList = accountService.getAccounts(userId);
		List<Integer> accountListBalance = new ArrayList<Integer>();
		
		for(int i = 0; i < accountList.size(); i++) {
			accountListBalance.add((int)accountList.get(i).getBalance());
		}
		
		request.setAttribute("accountList", accountList);
		request.setAttribute("accountListBalance", accountListBalance);
		return "account/view_my_accounts";
	}
}
