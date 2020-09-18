package com.threads;


import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ThreadLocalExample implements Runnable {

	private static final ThreadLocal<Integer> thread_local= new ThreadLocal<>();

	private static ThreadLocal<HashMap<Integer,String>> mapThreadLocal = ThreadLocal.withInitial(()->new HashMap<>());
	
	private final Processor processor;


	private final int value;
	
	public ThreadLocalExample(int value, Processor prc){

		this.value=value;
		processor=prc;
		
	}
	
	@Override
	public void run() {
		
		try {
			
			thread_local.get();
			thread_local.set(value);
			processor.process();
			mapThreadLocal.get()
					.put(thread_local.get(), Thread.currentThread()
							.getName());
			thread_local.remove();
			System.out.println("Map for current thread is " + mapThreadLocal.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static ThreadLocal<Integer> getThread_local() {
		return thread_local;
	}

	public static void main(String[] args){

		final var executorService = newFixedThreadPool(5);

		Processor prc=new Processor();
		IntStream.iterate(0,i->i<50,i->++i)
				.forEach(i->{
					executorService.execute(new ThreadLocalExample(i, prc));
				});

		executorService.shutdown();
	}
	
}


class Processor{
	
	public void process() throws InterruptedException{
		System.out.println("Thread Local value of "+Thread.currentThread().getName()+" from called method is "+ ThreadLocalExample.getThread_local().get() );
		Thread.sleep(1000);
		
	}

}
record Person(String name, int age) {
}
