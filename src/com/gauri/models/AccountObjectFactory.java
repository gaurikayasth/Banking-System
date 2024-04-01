package com.gauri.models;

public class AccountObjectFactory {
	public static Account getAccountInstance(int accountType)
	{
		switch(accountType)
		{
			case 1:
				return new SavingAccount();
			case 2:
				return new CurrentAccount();
			case 3:
				return new SalaryAccount();
			case 4:
				return new LoanAccount();
			default:
				return null;
		}
	}
}
