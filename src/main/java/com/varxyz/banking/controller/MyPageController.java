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
	
	/**
	 * myPage페이지
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping("/information/myPage")
	public String myPageForm(HttpSession session, HttpServletRequest request) {
		String userId = (String)session.getAttribute("userId");
		//로그인이 되어있지 않다면 돌아가기
		if(userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/banking/login_add/login");
			return "alert";
		}
		
		return "information/myPage";
	}
	
	/**
	 * mypage form페이지
	 * @param session
	 * @param request
	 * @return
	 */
	@PostMapping("/information/myPage")
	public String myPage(HttpSession session, HttpServletRequest request) {
		//필요한 데이터들을 저장.
		String passwd = request.getParameter("passwd");
		String userId = (String)session.getAttribute("userId");
		//이 유저가 누구인지 알기위한 코드
		Customer customer = customerService.getCustomerByUserId(userId);
		//입력한 비밀번호와 세션의 유저의 비밀번호가 틀렸을 경우.
		if(!customer.getPasswd().contentEquals(passwd)) {
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
			request.setAttribute("url", "myPage");
			return "alert";
		}
		
		//세션에 보여줄 계좌 수를 위한 쿼리.
		long accountNum = customerService.countAccountOnCustomer(userId);
		
		//다음 화면에 넘길 데이터 보내기.
		request.setAttribute("customer", customer);
		request.setAttribute("accountNum", accountNum);
		
		return "information/myPageInfo";
		
	}
	
}
