package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample  {

	

	
	public static void main(String[] args){
		ExecutorService executor=Executors.newFixedThreadPool(5);
		for(int i=0;i<50;i++){
			executor.execute(() -> {
				System.out.println("Processing " + Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		executor.shutdown();
	}
	
	
}
