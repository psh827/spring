package com.varxyz.jvx330;

import java.util.List;

import com.varxyz.banking.domain.Account;

public interface BankService {
	/**
	 * 회원가입 return은 String으로 반환
	 * @param 회원Id
	 * @param 비밀번호
	 * @param 이름
	 * @param 주민번호
	 * @param 전화번호
	 * @return
	 */
	String addCustomer(String 회원Id, String 비밀번호, String 이름, String 주민번호, String 전화번호);
	
	/**
	 * 계좌 등록 
	 * @param 계좌종류
	 * @param 회원Id
	 * @return
	 */
	Account addAccount(char 계좌종류, String 회원Id);
	/**
	 * 계좌조회
	 * @param 회원Id
	 * @return
	 */
	List<Account> getAccounts(String 회원Id);
	/**
	 * 이체. 이체 성공시 String으로 반환
	 * @param 출금계좌
	 * @param 입금계좌
	 * @param 이체금액
	 * @return
	 */
	String transfer(String 출금계좌, String 입금계좌, long 이체금액);
	/**
	 * 이자지급
	 * @param 이자율
	 * @param 계좌번호
	 * @return
	 */
	String saveInterest(double 이자율, String 계좌번호);
	/**
	 * 잔고조회
	 * @param 계좌번호
	 * @return
	 */
	long getBalance(String 계좌번호);
	
	
}
