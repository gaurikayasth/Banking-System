package com.gauri.models;

import java.time.LocalDate;

public class CurrentAccount extends Account{

	private Double overDraftLimit;
	private Double overDrafAmount;
	
	public CurrentAccount() {
		super();
		this.setInterestRate(0.03);
	}
	
	
	public CurrentAccount(Integer accountNumber, String accountHolderName, Double balance, Double interestRate,
			LocalDate accountOpeningDate,Double overDraftLimit, Double overDrafAmount) {
		super(accountNumber,accountHolderName,balance,interestRate,accountOpeningDate);
		this.overDraftLimit = overDraftLimit;
		this.overDrafAmount = overDrafAmount;
	}
	

	public Double getOverDraftLimit() {
		return overDraftLimit;
	}


	public void setOverDraftLimit(Double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}


	public Double getOverDrafAmount() {
		return overDrafAmount;
	}


	public void setOverDrafAmount(Double overDrafAmount) {
		this.overDrafAmount = overDrafAmount;
	}


	@Override
	public void openAccount() {
		System.out.println("\n-------------------------------------------------");
		System.out.println("To open current account,please fill the details");
		System.out.println("---------------------------------------------------");
		System.out.println("Enter the Account Number:");
		Integer accNum=getScanner().nextInt();
		System.out.println("Enter the Account Holder Name:");
		getScanner().nextLine();//consume new line
		String accHolderName=getScanner().nextLine();
		System.out.println("Enter the Balance:");
		Double Balance=getScanner().nextDouble();
		
		System.out.println("Enter the Overdraft Limit:");
		Double odLimit=getScanner().nextDouble();
		System.out.println("Enter the Overdraft balance:");
		Double od=getScanner().nextDouble();
		
		this.setAccountNumber(accNum);
		this.setAccountHolderName(accHolderName);
		this.setBalance(Balance);
		this.setOverDraftLimit(odLimit);
		this.setOverDrafAmount(od);
		this.setAccountOpeningDate(LocalDate.now());
		System.out.println("Account opened successfully!");
	}

	@Override
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
//		System.out.println("Enter Account number to close");
//		int Accountnum=getScanner().nextInt();
//		int index=searchAndDisplayAccount(a,Accountnum);
//		if(index==-1)
//		{
//			System.out.println("\nAccount to be deleted not present ");
//			return -1;
//		}
//		else
//		{
//			while(index<a.length-1)
//			{
//				a[index]=a[index+1];
//				index++;
//			}
//			System.out.println("Account Closed Successfully!");
//			return 1;
//		}
	}

	@Override
	public void depositAmount() {
		
			System.out.println("Enter the Ammount to be deposite");
			Double amt=getScanner().nextDouble();
			this.setBalance(this.getBalance()+amt);
			System.out.println("your balance:"+this.getBalance());
			System.out.println("Ammount deposited successfully!");
	}

	@Override
	public void withdrawAmount() {
			System.out.println("Enter the Ammount to be withdraw");
			Double amt=getScanner().nextDouble();
			Double tempAmt=this.getBalance()+this.getOverDraftLimit();
			
			try 
			{
				if(tempAmt>=amt)
				{
					if(this.getBalance()>amt)
					{
						this.setBalance(this.getBalance()-amt);
						System.out.println("your balance:"+this.getBalance());
						System.out.println("Ammount withdrawed successfully without OD!");
					}
					else
					{
						this.setBalance(tempAmt);
						this.setOverDraftLimit(this.getBalance()-amt);
						this.setBalance(0.0);
						System.out.println("your balance:"+this.getBalance());
						System.out.println("Ammount withdrawed successfully with OD!");
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
