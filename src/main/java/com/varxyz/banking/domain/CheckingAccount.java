package com.varxyz.banking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account{
	
	private double overAmount;

	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		
	}

}
