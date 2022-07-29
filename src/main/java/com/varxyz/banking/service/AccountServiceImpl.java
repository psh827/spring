package com.varxyz.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.domain.Account;

public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;

	@Override
	public void addAccounts(Account account) {
		accountDao.addAccount(account);
	}

	@Override
	public List<Account> getAccounts(String userId) {
		return accountDao.getAccounts(userId);
	}

	@Override
	public double getBalance(String accountNum) {
		return accountDao.getBalance(accountNum);
	}

	@Override
	public void transfer(double money, String withdrawAccountNum, String depositAccountNum) {
		accountDao.transfer(money, withdrawAccountNum, depositAccountNum);
		
	}

	@Override
	public void saveInterest(String accountNum, double interestRate) {
		accountDao.saveInterest(accountNum, interestRate);
	}
	
	@Override
	public void deposit(double depositMoney, String accountNum) {
		accountDao.deposit(depositMoney, accountNum);
	}

	
}
