package com.example;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random rand = new Random();
        System.out.println("nazwa: " + Thread.currentThread().getName());
        Thread.sleep(1800);
        return rand.nextInt(550);
    }
}
