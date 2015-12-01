package com.threads.fork;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ForkJoinPool pool= new ForkJoinPool();
		String fileseparator=System.getProperty("file.separator");
		String path=fileseparator+"Users"+fileseparator+"AjmalCholassery"+fileseparator+"Google Drive";
		FolderProcessor java = new FolderProcessor(path, "java");
		FolderProcessor text = new FolderProcessor(path, "txt");
		FolderProcessor excel = new FolderProcessor(path, "jpg");
		
		pool.execute(java);
		pool.execute(text);
		pool.execute(excel);
		
		do{
			System.out.printf("********************************\n");
			System.out.printf("Main: Parallelism: %d\n ",pool.getParallelism());
			System.out.printf("Main: ActiveCount: %d\n ",pool.getActiveThreadCount());
			System.out.printf("Main: TaskCount: %d\n ",pool.getQueuedTaskCount());
			System.out.printf("Main: StealCount: %d\n ",pool.getStealCount());
			System.out.printf("********************************\n");
			
			try
	         {
	            TimeUnit.SECONDS.sleep(1);
	         } catch (InterruptedException e)
	         {
	            e.printStackTrace();
	         }
			
		}while ((!java.isDone()) || (!text.isDone()) || (!excel.isDone()));
		
		pool.shutdown();
		List<String> results;
		results=java.join();
		System.out.printf("Java: %d files found.\n", results.size());
	    results = text.join();
	    System.out.printf("Text: %d files found.\n", results.size());
	    results = excel.join();
	    System.out.printf("Excel: %d files found.\n", results.size());
		
	}

}
