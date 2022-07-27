package com.varxyz.banking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class MyPageController {

	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("/information/myPage")
	public String myPageForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/banking/login_add/login");
			return "alert";
		}
		
		return "information/myPage";
	}
	
	@PostMapping("/information/myPage")
	public String myPage(HttpSession session, HttpServletRequest request) {
		String passwd = request.getParameter("passwd");
		String userId = (String)session.getAttribute("userId");
		Customer customer = customerService.getCustomerByUserId(userId);
		if(!customer.getPasswd().contentEquals(passwd)) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			request.setAttribute("url", "myPage");
			return "alert";
		}
		
		long accountNum = customerService.countAccountOnCustomer(userId);
		
		request.setAttribute("customer", customer);
		request.setAttribute("accountNum", accountNum);
		
		return "information/myPageInfo";
		
	}
	
}
