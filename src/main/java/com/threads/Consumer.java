package com.threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

BlockingQueue<Message> queue;
	
	public Consumer(BlockingQueue<Message> queue){
		this.queue=queue;
	}
	
	@Override
	public void run() {
		try {
			String msg;
			do{
				Thread.sleep(500);
				msg=queue.take().getMsg();
				System.out.println("Consumed :"+msg);
				
			}while(msg!="Exit");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
