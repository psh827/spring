package com.varxyz.banking.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
	private long cid;
	private String email;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private Date regDate;
	private String accountNum;
	public Customer() {
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}

	public Customer(long cid, String email, String passwd, String name, String ssn, String phone, Date regDate) {
		super();
		this.cid = cid;
		this.email = email;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.regDate = regDate;
	}
	
	
}
