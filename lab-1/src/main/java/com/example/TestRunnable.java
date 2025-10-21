package com.example;

public class TestRunnable implements Runnable {

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
    
}
