package com.practice.concurrency.basics.readerwriterproblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyWriter implements Runnable{

    private final int writerId;
    private final Lock writeLock;
    private SharedData sharedData;

    public MyWriter(int writerId, Lock writeLock, SharedData sharedData) {
        this.writerId = writerId;
        this.writeLock = writeLock;
        this.sharedData = sharedData;
    }
    @Override
    public void run() {
        while(true){
            try {
                writeLock.lock();
                System.out.println("Writer " + writerId + " is writing to the shared data.");
                sharedData.incrementSharedData();
                Thread.sleep(2000); // Simulate writing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                writeLock.unlock();  // Release write lock
                System.out.println("Writer " + writerId + " finished writing.");
            }
        }

    }
}
