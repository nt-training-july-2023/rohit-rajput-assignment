package com.multithreading.question2;

public class MultipleThreadRunning {
	
	public static void main(String[] args)
	{
           
            Thread thread1 = new Thread(new Runnable() {
            	public void show() {
            		System.out.println("hello");
            	}
				@Override
				public void run() 
				{
					for(int i=1;i<=10;i++)
					{
					   System.out.println(Thread.currentThread().getName() +":"+i);
					}
				}
			});
            Thread thread2 = new Thread(new Runnable()
            {
				
				@Override
				public void run()
				{
					for(int i=1;i<=10;i++) 
					{
				       System.out.println(Thread.currentThread().getName() +":"+i);
					}
				}
			});
            thread1.start();
            thread2.start();
            for(int i=1;i<=10;i++) {
            	 System.out.println(Thread.currentThread().getName()+":"+i);
            }
            
	}
}
