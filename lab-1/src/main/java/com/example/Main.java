package com.example;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Rozpoczęcie programu");
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Nawa " + Thread.currentThread().getName());
                for(int i = 0; i< 6; i++){
                    System.out.println("numer: " + i);
                    try {
                        Thread.sleep(1800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Wątek zakończył prace");
            }
        });
        // th1.start();
        // Thread th2 = new Thread(new TestRunnable());

        ExecutorService service = Executors.newFixedThreadPool(2);
        // for(int i = 0; i< 30;i++){
        //     service.submit(new TestCallable());
        // }
        Future<Integer> result = service.submit(new TestCallable());
        try {
            System.out.println("wylosowana liczba " + 
                    result.get(2300, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        service.shutdown();

        System.out.println("Zakończenie programu");
    }
}