package com.exception.customexception;

import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidInputException extends RuntimeException{
	public InvalidInputException(String exception) {
		super(exception);
	}
	public InvalidInputException() {
		
	}
}
class Account{
	private int balance;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	} 

}
public class ATMProgram {
      public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account account;
		int balance;
		int amount ;
		System.out.print("Enter the balance you want to credit :");
		try {
			balance =sc.nextInt();
			if(balance<0) {
				throw new InvalidInputException("Balance cannot be negative ");
			}
			
		    account = new Account();
		    account.setBalance(balance);
			System.out.print("Enter the withdraw amount :");
			amount =sc.nextInt();
		}
		catch(InputMismatchException exception) {
            throw new InvalidInputException("Entered wrong value:");
	    }
		if(amount<0) {
			throw new InvalidInputException("Entered negative value");
		}
		else if(amount>balance) {
			throw new InvalidInputException("Insufficient Balance ");
		}
		account.setBalance(balance-amount);
		System.out.println("Succesfully debited .....");
		System.out.println("Remaining balance :"+account.getBalance());
	}
	
}
