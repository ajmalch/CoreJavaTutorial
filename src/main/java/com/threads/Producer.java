package com.threads;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Message> queue;
	
	public Producer(BlockingQueue<Message> queue){
		this.queue=queue;
	}
	
	@Override
	public void run() {
		try {
			Message msg;
			for(int i=0,j=50;i<50;i++,j--){
				msg=new Message(" "+i);
				queue.put(msg);
				System.out.println("Produced :"+msg.getMsg());
				if(i<25)
					Thread.sleep(i*100);
				else
					Thread.sleep(j*100);
			}
		queue.put(new Message("Exit"));
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
