package com.multithreading.question8;

import java.util.Scanner;

class Account {
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void creadit(double amount) {
		this.balance = balance + amount;
	}

	public void withdraw(double amount) {
		this.balance = balance - amount;
	}
}

public class Transaction extends Thread {
	private Account account;

	public Transaction(Account account) {
		this.account = account;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount you want to credit:");
		double creditAmount = scanner.nextDouble();
		System.out.println("Enter the amount you want to withdraw :");
		double withdrawAmount = scanner.nextDouble();
		Account account = new Account(10000);

		Transaction creditThread1 = new Transaction(account) {
			@Override
			public void run() {
				if (creditAmount != 0) {
					System.out.println("Account balance before credit ...." + account.getBalance());

					synchronized (account) {
						account.creadit(creditAmount);
						System.out.println("Amount credit successfully.....");
						System.out.println("Balance after credit :" + account.getBalance());
						account.notify();
					}
				}
			}
		};

		Transaction withdrawThread1 = new Transaction(account) {

			@Override
			public void run() {
				synchronized (account) {
					try {
						account.wait(1000);
					} catch (InterruptedException e) {
					}
					if (withdrawAmount != 0) {
						System.out.println("Account balance before withdraw ...." + account.getBalance());
						if (withdrawAmount > account.getBalance()) {
							System.out.println("Sorry ,Insufficient amount...........");
							System.out.println("Your curret balance is :" + account.getBalance());
						} else {

							account.withdraw(withdrawAmount);
							System.out.println("Amount withdraw successfully.....");
							System.out.println("Amount after withdraw :" + account.getBalance());
							account.notify();
						}
					}
				}
			}
		};
		creditThread1.start();
		withdrawThread1.start();

		synchronized (account) {
			try {
				account.wait(1000);
			} catch (InterruptedException e) {
			}
			System.out.println("Account balance :" + account.getBalance());

		}

	}

}
