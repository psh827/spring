package com.varxyz.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.domain.CustomerCommand;
import com.varxyz.banking.service.CustomerServiceImpl;

@Controller
public class AddCustomerController {
	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("login_add/add_customer")
	public String addCustomerForm() {
		return "/login_add/add_customer";
	}
	
	@PostMapping("login_add/add_customer")
	public String addCustomer(CustomerCommand customerCommand, Model model) {
		model.addAttribute("customerCommand", customerCommand);	
		Customer customer = new Customer();
		customer.setEmail(customerCommand.getEmail());
		customer.setPasswd(customerCommand.getPasswd());
		customer.setName(customerCommand.getName());
		customer.setSsn(customerCommand.getSsn());
		customer.setPhone(customerCommand.getPhone());
		customerService.addCustomer(customer);
		return "login_add/add_success_customer";
	}
}
