package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });

        executorService.shutdownNow(); //지금 돌고있는 스레드 상관없이 죽인다.


    }

}
