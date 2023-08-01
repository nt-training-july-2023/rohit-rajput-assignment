package com.multithreading.threadexecutor;

import java.util.concurrent.TimeUnit;

public class LoopTask implements Runnable{
    
	private static int count=0;
	private int id;
	@Override
	public void run() {
		System.out.println("####### <TASK-"+id+"STARTING #######");
		for(int i=1;i<=10;i++) {
			System.out.println("<"+id+">TICK TICK -" +i);
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("******<TASK-"+id+"> COMPLETED *****");
	}
	
	public LoopTask() {
		this.id=++count;
	}

}
