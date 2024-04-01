package com.gauri.models;

import java.time.LocalDate;

public class LoanAccount extends SavingAccount{
	
	private Double repay;
	
	public LoanAccount() {
		super();
		this.repay=0.0;
		this.setInterestRate(0.09);
	}	
	
	
	public LoanAccount(Integer accountNumber, String accountHolderName, Double balance, Double interestRate,
			LocalDate accountOpeningDate,Double repay) {
		super(accountNumber,accountHolderName,balance,interestRate,accountOpeningDate);
		this.repay = repay;
	}

	
	public Double getRepay() {
		return this.repay;
	}


	public void setRepay(Double repay) {
		this.repay = repay;
	}


	public void openAccount() {
		System.out.println("\n-------------------------------------------------");
		System.out.println("To open Loan account,please fill the details");
		System.out.println("-------------------------------------------------");
		System.out.println("Enter the Account Number:");
		Integer accNum=getScanner().nextInt();
		System.out.println("Enter the Account Holder Name:");
		getScanner().nextLine();//consume new line
		String accHolderName=getScanner().nextLine();
		System.out.println("Enter the Balance:");
		Double Balance=getScanner().nextDouble();
		
		this.setAccountNumber(accNum);
		this.setAccountHolderName(accHolderName);
		this.setBalance(Balance);
		this.setAccountOpeningDate(LocalDate.now());
		System.out.println("Account opened successfully!");
	}

	public int closeAccount(Account[] a,int acNum) {
		int i;
		for(i=0;i<a.length;i++)
		{
			if(a[i].getAccountNumber()==acNum) {
				break;
			}
		}
		while(i<a.length-1)
		{
			a[i]=a[i+1];
			i++;
		}
		System.out.println("Account Closed Successfully!");
		return 1;
	}

	public void depositAmount() {
			System.out.println("Enter the Ammount to be deposite");
			Double amt=getScanner().nextDouble();
			this.setRepay(amt);
			this.setBalance(this.getBalance()-this.getRepay());
			System.out.println("your balance:"+this.getBalance());
			System.out.println("Ammount deposited successfully!");
	}

	public void withdrawAmount() {
		try
		{
			throw new LowBalanceException("We can't withdraw money from Loan Account");
		}
		catch(LowBalanceException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void calculateInterest() {
		Double amt=this.getBalance()*this.getInterestRate();
		System.out.println("your interest ammount on balance "+this.getBalance()+" is="+amt+"Rs");
	}
	
	@Override
	public void showTransactions() {
		System.out.println("-------------------------------------------------");
		System.out.println("Account Number:"+this.getAccountNumber());
		System.out.println("Account Holder Name:"+this.getAccountHolderName());
//		this.setBalance(this.getBalance()+(this.getBalance()*this.getInterestRate()));
		System.out.println("Account Balance:"+this.getBalance());
		System.out.println("Account Interest Rate:"+this.getInterestRate());
		System.out.println("Account Opening Date:"+this.getAccountOpeningDate());
		System.out.println("-------------------------------------------------");
	}
}
