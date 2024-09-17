package com.practice.concurrency.basics.readerwriterproblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyReader implements Runnable{
    private final int id;
    private final Lock readLock;
    private  SharedData sharedData;

    public MyReader(int id, Lock readLock, SharedData sharedData){
        this.id = id;
        this.readLock = readLock;
        this.sharedData = sharedData;
    }
    @Override
    public void run() {
        while( true ){
            try{
                readLock.lock();
                System.out.println("Reader " + id + " is reading the shared data: " + sharedData.getSharedData());
                Thread.sleep(1000);

            }catch ( Exception e){
                System.out.println(" Error while running reader");
            }finally {
                readLock.unlock();
            }
        }

    }
}
