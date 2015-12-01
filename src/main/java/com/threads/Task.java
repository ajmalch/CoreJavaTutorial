package com.threads;

import java.util.Date;

/**
 * Created by AjmalCholassery on 8/18/15.
 */
public class Task implements Runnable {

    String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing task during :"+ this.getName() + " - Time - " + new Date());
    }
}
