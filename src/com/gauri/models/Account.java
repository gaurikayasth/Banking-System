package com.gauri.models;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Account {
	private Scanner scanner=new Scanner(System.in);
	
	
	public Scanner getScanner() {
		return scanner;
	}

	public void closeScanner() {
		System.out.println("closing scanner");
		scanner.close();;
	}
	
	//data members
	private Integer accountNumber;
	private String accountHolderName;
	private Double balance;
	private Double interestRate;
	private LocalDate accountOpeningDate;
	
	public Account() {
		this.accountNumber=0;
		this.accountHolderName=null;
		this.balance=0.0;
		this.interestRate=0.05;
		this.accountOpeningDate=null;
	}

	public Account(Integer accountNumber, String accountHolderName, Double balance, Double interestRate,
			LocalDate accountOpeningDate) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpeningDate = accountOpeningDate;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(LocalDate accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	
	public abstract void openAccount();
	public abstract int closeAccount(Account[] a,int accNo);
	public abstract void depositAmount();
	public abstract void withdrawAmount();
	public abstract void calculateInterest();
	public abstract void showTransactions();

	public static void display(Account[] a)
	{
		if(a.length==0)
		{
			System.out.println("XYZ Bank does not have any Account...");
		}
		else
		{
			for(int i=0;i<a.length;i++)
			{
				a[i].showTransactions();
			}
		}
	}
	@Override
	public String toString() {
		System.out.println("\n\nAccount Information::");
		return "accountNumber="+accountNumber+"\naccountHolderName="+accountHolderName+
				"\nbalance="+balance+"\ninterestRate="+interestRate+"\naccountOpeningDate="
		+accountOpeningDate;
	}
}
