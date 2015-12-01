package com.threads;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by AjmalCholassery on 8/18/15.
 */
public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor= new ScheduledThreadPoolExecutor(2);

        Task[] tasks= new Task[10];
        for(int i=0; i<10; i++){
            tasks[i]= new Task("Demo Task" + i);
        }

        System.out.println("The time is  " + new Date());

        for (int i=0;i<10;i++){
            int wait_time=5;
            if(i%2==0) wait_time=10;
            executor.schedule(tasks[i],wait_time, TimeUnit.SECONDS);
        }
        //executor.schedule(tasks[3],2, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(()-> System.out.println("Running every 5 seconds"),10, 5,TimeUnit.SECONDS);

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
