package com.multithreading.question4;

import java.util.Scanner;

public class ThreadWaitingForInput {

	private int value;

	public static void main(String[] args) throws InterruptedException {

		ThreadWaitingForInput obj = new ThreadWaitingForInput();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				Scanner scanner = new Scanner(System.in);
				synchronized (this) {
					System.out.println("Please Enter The Number");
					int x = scanner.nextInt();
					obj.value = x;
					System.out.println("child thread giving the notification");
					this.notify();
				}

			}
		});

		thread.start();
		synchronized (thread) {
			System.out.println("Main thread calling wait method");
			thread.wait(1000);
            System.out.println("Main thread got the notification");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i * obj.value);
		}
		}

	}
}
