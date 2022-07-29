package com.varxyz.banking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCommand {
	private String email1;
	private String email2;
	private String email = email1 + "@" + email2;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
}
