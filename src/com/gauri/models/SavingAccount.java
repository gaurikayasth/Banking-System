package com.gauri.models;

import java.time.LocalDate;
import java.util.Arrays;

public class SavingAccount extends Account{
	
	public SavingAccount() {
		super();
		this.setInterestRate(0.04);
	}

	public SavingAccount(Integer accountNumber, String accountHolderName, Double balance, Double interestRate,
			LocalDate accountOpeningDate) {
		super(accountNumber,accountHolderName,balance,interestRate,accountOpeningDate);
		this.setInterestRate(0.04);
	}
	@Override
	public void openAccount() {
		System.out.println("\n-------------------------------------------------");
		System.out.println("To open saving account,please fill the details");
		System.out.println("-------------------------------------------------");
		System.out.println("Enter the Account Number");
		Integer accNumSaving=getScanner().nextInt();
		System.out.println("Enter the Account Holder Name");
		getScanner().nextLine();//consume new line
		String accHolderNameSaving=getScanner().nextLine();
		System.out.println("Enter the Balance");
		Double savingBalance=getScanner().nextDouble();
		try 
		{
			if(savingBalance<10000)
			{
				throw new LowBalanceException("it is necessary to have an average minimum balance of 10000 rs..");
			}
			else
			{
				this.setAccountNumber(accNumSaving);
				this.setAccountHolderName(accHolderNameSaving);
				this.setBalance(savingBalance);
				this.setAccountOpeningDate(LocalDate.now());
				System.out.println("Account opened successfully!");
			}
		}
		catch(LowBalanceException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public int closeAccount(Account[] a,int acNum) {
		int i;
		for(i=0;i<a.length;i++)
		{
			if(a[i].getAccountNumber()==acNum) {
				break;//break at index where account found
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

	@Override
	public void depositAmount() {
		System.out.println("Enter the Ammount to be deposite");
		Double amt=getScanner().nextDouble();
	
		try 
		{
			if(this.getBalance()<10000)
			{
				throw new LowBalanceException("it is necessary to have an average minimum balance of 10000 rs..");
			}
			else
			{
				this.setBalance(this.getBalance()+amt);
				System.out.println("your balance:"+this.getBalance());
				System.out.println("Ammount deposited successfully!");
			}
		}
		catch(LowBalanceException e)
		{
			System.out.println(e.getMessage());
		}
		//ten thousand limit
	}

	@Override
	public void withdrawAmount() {
		System.out.println("Enter the Ammount to be withdraw");
		Double amt=getScanner().nextDouble();
		Double tempAmt=this.getBalance()-amt;
		
		try 
		{
			if(this.getBalance()>=amt)
			{
				if(tempAmt>10000)
				{
					this.setBalance(this.getBalance()-amt);
					System.out.println("your balance:"+this.getBalance());
					System.out.println("Ammount withdrawed successfully!");
				}
				else
				{
					throw new LowBalanceException("it is necessary to have an average minimum balance of 10000 rs..");
				}
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
