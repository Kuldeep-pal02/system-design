package com.practice.concurrency.basics.producerconsumer;

import java.util.LinkedList;
import java.util.Random;

public class SingleClassProducerConsumer {

    //private static SharedBuffer sharedBuffer;

    private static BufferForProducerConsumer sharedBuffer;


    public static void main(String[] args) {

        sharedBuffer = new SharedBuffer( new LinkedList<>(), 2);
        sharedBuffer = new SharedBufferWithBlockingQueue( 2);
        Random random = new Random();
        Runnable producer = new Runnable() {
            int value = 0;
            @Override
            public void run() {
                while( true ){
                    try {
                        sharedBuffer.produce(value++);
                        Thread.sleep( random.nextInt( 5000 )+1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while( true ){
                    try {
                        sharedBuffer.consume();
                        Thread.sleep( random.nextInt( 5000 )+1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread producerThread = new Thread( producer );
        Thread consumerThread = new Thread( consumer );
        Thread producerThread1 = new Thread( producer );
        Thread consumerThread1 = new Thread( consumer );
        Thread producerThread2 = new Thread( producer );
        Thread consumerThread2 = new Thread( consumer );
        Thread producerThread3 = new Thread( producer );
        Thread consumerThread3 = new Thread( consumer );
        producerThread.start();
        consumerThread.start();
        producerThread1.start();
        consumerThread1.start();
        producerThread2.start();
        consumerThread2.start();
        producerThread3.start();
        consumerThread3.start();

    }

}
