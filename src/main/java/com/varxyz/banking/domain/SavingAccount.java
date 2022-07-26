package com.varxyz.banking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingAccount extends Account{

	private double interestRate;
	
	@Override
	public void transfer() {
		
	}

}
