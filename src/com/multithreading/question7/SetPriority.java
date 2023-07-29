package com.multithreading.question7;

public class SetPriority {
  public static void main(String[] args) {
	System.out.println("Default Priority :"+Thread.currentThread().getName()+" : "
                           +Thread.currentThread().getPriority());
	Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Default Child Thread priority......");
			System.out.println(Thread.currentThread().getName()+" :"
			                     +Thread.currentThread().getPriority());
		}
	});
	thread.start();
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    System.out.println("Priority after setting :"+Thread.currentThread().getName()+" : "
                          +Thread.currentThread().getPriority());
    
    Thread thread2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Priority of Child Thread after setting ");
			System.out.println(Thread.currentThread().getName()+" : "
			                     +Thread.currentThread().getPriority());
			
		}
	});
    thread2.setPriority(Thread.MIN_PRIORITY);
    thread2.start();
}
}
