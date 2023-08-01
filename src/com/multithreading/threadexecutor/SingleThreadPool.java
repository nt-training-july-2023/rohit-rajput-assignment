package com.multithreading.threadexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		for(int i=0;i<6;i++) {
		    service.execute(new LoopTask());
		}
		service.shutdown();
		System.out.println("Main thread ends here...");
	}
}
