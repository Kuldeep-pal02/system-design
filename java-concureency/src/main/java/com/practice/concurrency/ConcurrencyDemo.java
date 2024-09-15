package com.practice.concurrency;

public class ConcurrencyDemo {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                System.out.println( " Inside Runnable ");
                try {
                    Thread.sleep( 1000 );
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println( "Runnable thread is  - " + Thread.currentThread().getName() );
            }
        };
        Thread thread = new Thread( runnable );
        thread.start();
        System.out.println( "Main thread is  - " + Thread.currentThread().getName() );
    }
}
