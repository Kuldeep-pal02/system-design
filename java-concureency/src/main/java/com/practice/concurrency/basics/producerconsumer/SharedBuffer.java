package com.practice.concurrency.basics.producerconsumer;

import lombok.Data;

import java.util.Collections;
import java.util.Queue;

@Data
public class SharedBuffer {
    private final Queue<Integer> sharedQueue;
    private final int capacity;

    public SharedBuffer( Queue<Integer> sharedQueue, int capacity){
        this.sharedQueue = sharedQueue;
        this.capacity = capacity;
    }

    public synchronized void produce( int number) throws InterruptedException {
        while ( sharedQueue.size() == capacity ){
            wait();
            System.out.println(" Waiting : to produce since queue is full" + Thread.currentThread().getName());
        }

        sharedQueue.add( number );
        if( sharedQueue.size() > capacity  ){
            System.out.println( "Queue exploeded.");
        }
        System.out.println( "Produced NUmber : "+ number +":::" + Thread.currentThread().getName());
        notify();
    }

    public synchronized  void consume( ) throws InterruptedException {
        while( sharedQueue.isEmpty() ){
            wait();
            System.out.println(" Waiting : to consume since queue is empty"+ Thread.currentThread().getName());
        }
        int number = sharedQueue.poll();
        notify();
        System.out.println( "Consumed NUmber : "+ number +":::" + Thread.currentThread().getName());
    }
}
