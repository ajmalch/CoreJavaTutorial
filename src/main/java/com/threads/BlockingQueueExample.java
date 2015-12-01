package com.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {
		BlockingQueue<Message> queue=new ArrayBlockingQueue<Message>(5);
		Thread producer=new Thread(new Producer(queue));
		Thread consumer=new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}

}
