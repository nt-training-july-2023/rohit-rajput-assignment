package com.multithreading.question5;

public class ThreadState {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread-0 is in Running State");
				try {
					//thread in waiting state
					System.out.println("Thread-0 in waiting state");
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				System.out.println("Thread-0 back to Running state");
			}
		});
		System.out.println("Thread-0 is in New State");
		System.out.println("Thread-0 is in Runnable state");
		thread.start();
		thread.join();
		System.out.println("Thread-0 is  Terminated ");
	}

}
