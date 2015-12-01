package com.threads;

public class ThreadLocalExample implements Runnable {

	private static ThreadLocal<Integer> thread_local=new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			return Integer.valueOf(0);
		}
	}; 
	
	private Processor processor;


	private int value;
	
	public ThreadLocalExample(int value, Processor prc){

		this.value=value;
		processor=prc;
		
	}
	
	@Override
	public void run() {
		
		try {
			
			thread_local.get();
			thread_local.set(value);
			System.out.println("Thread Local value of "+Thread.currentThread().getName()+"is "+ thread_local.get() );
			processor.process();
			System.out.println("Thread Local value of "+Thread.currentThread().getName()+"is "+ thread_local.get() );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static ThreadLocal<Integer> getThread_local() {
		return thread_local;
	}

	public static void main(String[] args){
		
		Processor prc=new Processor();
		Thread t1=new Thread(new ThreadLocalExample(12,prc));
		Thread t2=new Thread(new ThreadLocalExample(15,prc));
		Thread t3=new Thread(new ThreadLocalExample(122,prc));
		t1.start();
		t2.start();
		t3.start();
	}
	
}


class Processor{
	
	public void process() throws InterruptedException{
		System.out.println("Thread Local value of "+Thread.currentThread().getName()+" from called method is "+ ThreadLocalExample.getThread_local().get() );
		Thread.sleep(2000);
		
	}
	
}