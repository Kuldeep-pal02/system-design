package com.practice.concurrency.basics.singleton;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleDriver {
    private static  AtomicInteger atomicInteger = new AtomicInteger( 0);
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executorService = new ThreadPoolExecutor( );
        MySingleton singleton = MySingleton.getInstance();
        MySingleton singleton1 = MySingleton.getInstance();

        MySingleton[] mySingletons = new MySingleton[ 1000 ];
        //usingSimpleThreadArray();
        usingExecutorFramework();

    }

    private static void usingExecutorFramework(){
        int numberOfThreads = 100;
        int numberOfInstances = 100000;
        ExecutorService executorService = Executors.newFixedThreadPool( numberOfThreads );
        getTask();
        for(  int i=0;i<numberOfInstances;i++){
            executorService.submit( getTask() );
        }

        executorService.shutdown();


    }
    private static Runnable getTask(){
        return () -> {
            MySingleton instance = MySingleton.getInstance();
            System.out.println(instance.hashCode() + " ==" + Thread.currentThread().getName() +"=="+ atomicInteger.incrementAndGet());
        };
    }
    private static void usingSimpleThreadArray() throws InterruptedException {

        int size = 100000;
        Thread[] threads = new Thread[size];


        for( int i=0;i<size;i++){
            threads[i]= new Thread(getTask());
        }

        for( int i=0;i<size;i++){
            threads[i].start();
        }

        for( int i=0;i<size;i++){
            threads[i].join();
        }
    }
}
