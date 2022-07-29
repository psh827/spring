package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class ViewAllCustomer {
	@Autowired
	CustomerServiceImpl customerService;

	/**
	 * 전체 회원 조회
	 * @param request
	 * @return
	 */
	@GetMapping("/information/view_all_customers")
	public String viewAllCustomer(HttpServletRequest request) {
		List<Customer> customerList = customerService.getAllCustomer();
		request.setAttribute("customerList", customerList);
		
		return "information/view_all_customers";
	}
}
