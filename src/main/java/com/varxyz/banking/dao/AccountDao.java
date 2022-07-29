package com.varxyz.banking.dao;

import static java.sql.Types.BIGINT;
import static java.sql.Types.CHAR;
import static java.sql.Types.DOUBLE;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.domain.Account;
import com.varxyz.banking.domain.CheckingAccount;
import com.varxyz.banking.domain.SavingAccount;


public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * 계좌 생성.
	 * @param account
	 */
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {BIGINT, CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE};
		
		if(account instanceof SavingAccount) {
			sa = (SavingAccount)account;
			args = new Object[] {
					sa.getCustomer().getCid(), sa.getAccountNum(), String.valueOf(sa.getAccType()),
					sa.getBalance(), sa.getInterestRate(), 0.0
			};
		}else {
			ca = (CheckingAccount)account;
			args = new Object[] {
					ca.getCustomer().getCid(), ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), 0.0, ca.getOverAmount()
			};
		}
			
		jdbcTemplate.update(sql, args, types);
		System.out.println("계좌신청 완료");
	}
	
	/**
	 * email(userId)로 계좌 얻기
	 * @param email
	 * @return
	 */
	public List<Account> getAccounts(String email){
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
				+ " WHERE c.email=?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), email);
	}
	
	/**
	 * 이체
	 * @param money
	 * @param withdrawAccountNum
	 * @param depositAccountNum
	 */
	public void transfer(double money, String withdrawAccountNum, String depositAccountNum) {
		String sql = "UPDATE Account SET balance = balance - ? WHERE accountNum=?";
		String sql2 = "UPDATE Account SET balance = balance + ? WHERE accountNum=?";
		jdbcTemplate.update(sql, money, withdrawAccountNum);
		jdbcTemplate.update(sql2, money, depositAccountNum);
		System.out.println("송금완료");
	}
	
	/**
	 * 이자
	 * @param accountNum
	 * @param interestRate
	 */
	public void saveInterest(String accountNum, double interestRate) {
		String sql = "UPDATE Account SET balance = balance + "
				+ "(balance * (balance / ?)) WHERE accountNum=?";
		jdbcTemplate.update(sql, interestRate, accountNum);
	}
	
	/**
	 * 계좌번호별 잔액 조회
	 * @param accountNum
	 * @return
	 */
	public double getBalance(String accountNum) {
		try {
			String sql = "SELECT a.balance FROM Account a INNER JOIN Customer c ON"
					+ " a.customerId = c.cid WHERE a.accountNum=?";
			
			return jdbcTemplate.queryForObject(sql, Long.class, accountNum);			
		}catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}
	
	/**
	 * 입금
	 * @param depositMoney
	 * @param accountNum
	 */
	public void deposit(double depositMoney, String accountNum) {
		String sql = "UPDATE Account SET balance = balance + ? WHERE accountNum=?";
		jdbcTemplate.update(sql, depositMoney, accountNum);
	}
	
}
