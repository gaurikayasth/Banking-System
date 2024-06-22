package com.gauri;
import java.util.Arrays;
import java.util.Scanner;

import com.gauri.models.*;
public class XYZBank {
	public static void main(String[] args) {
		int choice = 0;
		
		Account[] a=new Account[0];
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\t\t\t\t\t================================================\n");
	    System.out.println("\t\t\t\t\t||                  WELCOME TO                ||\n");
	    System.out.println("\t\t\t\t\t||                                            ||\n");
	    System.out.println("\t\t\t\t\t||           BANKING SYSTEM PROJECT           ||\n");
	    System.out.println("\t\t\t\t\t||                                            ||\n");
	    System.out.println("\t\t\t\t\t||        Developer : Gauri Shankar Kayasth   ||\n");
	    System.out.println("\t\t\t\t\t================================================");
		while(choice!=8)
		{
			System.out.println("\n\nMAIN MENU");
			System.out.println("-------------------------");
			System.out.println("1.Open Account");
			System.out.println("2.Deposit Ammount");
			System.out.println("3.Withdraw Ammount");
			System.out.println("4.Calculate Interest");
			System.out.println("5.Show Transactions");
			System.out.println("6.Show All Accounts");
			System.out.println("7.Close Account");
			System.out.println("8.Exit");
			System.out.println("-------------------------");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					a=Arrays.copyOf(a,a.length+1);
					
					System.out.println("\nChoose The Account Type=");
					System.out.println("1.Saving Account");
					System.out.println("2.Current Ammount");
					System.out.println("3.Salary Ammount");
					System.out.println("4.Loan Interest");
					
					int accountType=sc.nextInt();
					
					a[a.length-1]=AccountObjectFactory.getAccountInstance(accountType);
					
					a[a.length-1].openAccount();
					break;
				case 2:
					if(a.length==0)
					{
						System.out.println("XYZ Bank does not have any Account...");
					}
					else
					{
						System.out.println("Enter your Account number to deposite Amount");
						int acNum=sc.nextInt();
						Account obj=search(a,acNum);
						if(obj==null)
							System.out.println("Account not found");
						else {
							obj.showTransactions();
							obj.depositAmount();
						}
					}
					break;
				case 3:
					if(a.length==0)
					{
						System.out.println("XYZ Bank does not have any Account...");
					}
					else
					{
						System.out.println("Enter your Account number to withdraw Amount");
						int acNum=sc.nextInt();
						Account obj=search(a,acNum);
						if(obj==null)
							System.out.println("Account not found");
						else {
							obj.showTransactions();
							obj.withdrawAmount();
						}
					}
					break;
				case 4:
					if(a.length==0)
					{
						System.out.println("XYZ Bank does not have any Account...");
					}
					else
					{
						System.out.println("Enter your Account number to calculate interest");
						int acNum=sc.nextInt();
						Account obj=search(a,acNum);
						if(obj==null)
							System.out.println("Account not found");
						else
							obj.calculateInterest();
					}
					break;
				case 5:
					if(a.length==0)
					{
						System.out.println("XYZ Bank does not have any Account...");
					}
					else
					{
						System.out.println("Enter your Account number to see the transactions");
						int acNum=sc.nextInt();
						Account obj=search(a,acNum);
						if(obj==null)
							System.out.println("Account not found");
						else
							obj.showTransactions();
					}					
					break;
				case 6:
					Account.display(a);
					break;
				case 7:
					if(a.length==0)
					{
						System.out.println("XYZ Bank does not have any Account to close...");
					}
					else
					{
						System.out.println("Enter your Account number to close");
						int acNum=sc.nextInt();
						Account obj=search(a,acNum);
						if(obj==null)
							System.out.println("Account not found");
						else
						{
							obj.showTransactions();
							int isClose=obj.closeAccount(a,acNum);
							if(isClose==1)
							{
								a=Arrays.copyOf(a,a.length-1);
							}
						}
					}
					break;
				case 8:
					System.out.println("Thank You!");
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
		}
		sc.close();
	}

	private static Account search(Account[] arr, int acNum) {
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].getAccountNumber()==acNum) {
				return arr[i];
			}
		}
		return null;
	}
}
