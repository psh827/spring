package com.varxyz.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	@Override
	public boolean isUser(String userId, String passwd) {
		return customerDao.isUser(userId, passwd);
	}
	
	@Override
	public Customer getCustomerByUserId(String userId) {
		return customerDao.getCustomerByUserId(userId);
	}
	
	@Override
	public Customer getCustomerByAccountNum(String accountNum) {
		return customerDao.getCustomerByAccountNum(accountNum);
	}
	
	@Override
	public long countAccountOnCustomer(String userId) {
		return customerDao.countAccountOnCustomer(userId);
	}
	
	@Override
	public List<Customer> getAllCustomer(){
		return customerDao.getAllCustomer();
	}
	
}



