package com.gauri.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SalaryAccount extends SavingAccount{
	private Double salary;
	private LocalDate transactionDate;
	
	public SalaryAccount() {
		super();
		this.setInterestRate(0.04);
	}
	
	public SalaryAccount(Integer accountNumber, String accountHolderName, Double balance, Double interestRate,
			LocalDate accountOpeningDate,Double salary, LocalDate transactionDate) {
		super(accountNumber,accountHolderName,balance,interestRate,accountOpeningDate);
		this.salary = salary;
		this.transactionDate = transactionDate;
	}


	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void openAccount() {
		
		System.out.println("\n-------------------------------------------------");
		System.out.println("To open salary account,please fill the details");
		System.out.println("-------------------------------------------------");
		System.out.println("Enter the Account Number:");
		Integer accNum=getScanner().nextInt();
		System.out.println("Enter the Account Holder Name:");
		getScanner().nextLine();//consume new line
		String accHolderName=getScanner().nextLine();
		System.out.println("Enter the Balance:");
		Double Balance=getScanner().nextDouble();
		
		System.out.println("Enter the salary:");
		Double salary=getScanner().nextDouble();
		
		this.setAccountNumber(accNum);
		this.setAccountHolderName(accHolderName);
		this.setBalance(Balance);
		this.setSalary(salary);
		this.setAccountOpeningDate(LocalDate.now());
		System.out.println("Account opened successfully!");
		
		this.setTransactionDate(LocalDate.now());
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
		if(getTransactionDate().until(LocalDate.now(),ChronoUnit.MONTHS)>2)
		{
			System.out.println("your account is frozen");
		}
		else
		{
			System.out.println("Enter the Ammount to be deposite");
			Double amt=getScanner().nextDouble();
			this.setBalance(this.getBalance()+amt);
			System.out.println("your balance:"+this.getBalance());
			System.out.println("Ammount deposited successfully!");
		this.setTransactionDate(LocalDate.now());
		}
	}

	public void withdrawAmount() {
		if(getTransactionDate().until(LocalDate.now(),ChronoUnit.MONTHS)>2)
		{
			System.out.println("your account is frozen");
		}
		else
		{
		System.out.println("Enter the Ammount to be withdraw");
		Double amt=getScanner().nextDouble();
		Double tempAmt=this.getBalance()-amt;
		
		try 
		{
			if(this.getBalance()>=amt)
			{
				this.setBalance(this.getBalance()-amt);
				System.out.println("your balance:"+this.getBalance());
				System.out.println("Ammount withdrawed successfully!");
		    }
			else
			{
				throw new LowBalanceException("You don't have sufficient balance to withdraw..");
			}
		}
		catch(LowBalanceException e)
		{
			System.out.println(e.getMessage());
		}
		this.setTransactionDate(LocalDate.now());
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
