package com.varxyz.jvx330;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.banking.dao.AccountDao;
import com.varxyz.banking.domain.Account;

public class TransferAccount implements BankService{

	@Autowired
	AccountDao accountDao;
	
	@Override
	public String addCustomer(String 회원Id, String 비밀번호, String 이름, String 주민번호, String 전화번호) {
		return null;
	}

	@Override
	public Account addAccount(char 계좌종류, String 회원Id) {
		return null;
	}

	@Override
	public List<Account> getAccounts(String 회원Id) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String transfer(String 출금계좌, String 입금계좌, long 이체금액) {
		String answer = "";
		answer = "이체시작";
		accountDao.transfer(이체금액, 출금계좌, 입금계좌);
		answer = "이체종료";
		return answer;
	}

	@Override
	public String saveInterest(double 이자율, String 계좌번호) {
		return null;
	}

	@Override
	public long getBalance(String 계좌번호) {
		return 0;
	}

}
