package com.threads;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        final var networkService = new LatchService(countDownLatch, "Network Service");
        final var databaseService = new LatchService(countDownLatch, "Database Service");
        final var messagingService = new LatchService(countDownLatch, "Messaging Service");

        final var services = List.of(networkService, databaseService, messagingService);

        final var executorService = Executors.newFixedThreadPool(services.size());

        for (LatchService service: services) {
            executorService.execute(service);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Thread interrupted while waiting for services to initialize");
        }

        System.out.println("All services are up!");

        executorService.shutdown();
    }


}

class LatchService implements Runnable{

    private final CountDownLatch countDownLatch;
    private final String serviceName;

    public LatchService(CountDownLatch countDownLatch, String serviceName) {
        this.countDownLatch = countDownLatch;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {

        Instant start = Instant.now();
        System.out.println("Initializing "+ serviceName);
        sleep();
        System.out.println("Initialized " + serviceName);
        Instant end = Instant.now();

        System.out.println(serviceName + " took " + Duration.between(start,end).getSeconds() +" seconds to start");

        countDownLatch.countDown();

    }

    private void sleep() {
        try {
            long seconds = 4;
            if(LocalTime.now().getSecond()%2 == 0)
                seconds = 2;
            Thread.sleep(Long.valueOf(seconds) *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}