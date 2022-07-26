package com.varxyz.banking.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public abstract class Account {
	private long aid;
	private Customer customer;
	private String accountNum;
	private char accType;
	private double balance;
	private Date regDate;
	
	public Account() {
		
	}
	
	public abstract void transfer();

	
	public String toString() {
		return "계좌번호 : " + accountNum + " | 계좌타입 : " + accType + " | 잔고 : "
				+ balance;
	}
}
