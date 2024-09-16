package com.practice.concurrency.basics.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedBufferWithBlockingQueue implements BufferForProducerConsumer{
    private final int capacity;
    private BlockingQueue<Integer> blockingDeque;
    public SharedBufferWithBlockingQueue( int capacity){
        this.capacity = capacity;
        this.blockingDeque = new ArrayBlockingQueue<>(capacity);
    }

    @Override
    public synchronized void produce( int number) throws InterruptedException {
        while ( blockingDeque.size() == capacity ){
            wait();
            System.out.println(" Waiting : to produce since queue is full" + Thread.currentThread().getName());
        }

        blockingDeque.add( number );
        System.out.println( "Produced NUmber : "+ number +":::" + Thread.currentThread().getName());
        notify();
    }

    @Override
    public synchronized  void consume() throws InterruptedException {
        while( blockingDeque.isEmpty() ){
            wait();
            System.out.println(" Waiting : to consume since queue is empty"+ Thread.currentThread().getName());
        }
        int number = blockingDeque.poll();
        notify();
        System.out.println( "Consumed NUmber : "+ number +":::" + Thread.currentThread().getName());
    }
}
