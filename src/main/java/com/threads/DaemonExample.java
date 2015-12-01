package com.threads;

public class DaemonExample implements Runnable {

	
	public static void main(String[] args) throws InterruptedException{
		
		System.out.println("Main Thread Starting");
		Thread daemon=new Thread(new DaemonExample());
		daemon.setDaemon(true);
		daemon.start();
		Thread.sleep(50000);
		System.out.println("Finishing Main Thread");
	}
	
	
	
	@Override
	public void run() {
		while(true){
			System.out.println("Daemon thread running");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
