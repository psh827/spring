package com.varxyz.banking.service;

import java.util.List;

import com.varxyz.banking.domain.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	boolean isUser(String userId, String passwd);
	Customer getCustomerByUserId(String userId);
	Customer getCustomerByAccountNum(String accountNum);
	long countAccountOnCustomer(String userId);
	List<Customer> getAllCustomer();
}
