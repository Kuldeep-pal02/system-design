package com.practice.concurrency.basics.readerwriterproblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDriver {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock( true );
        Lock readLock = reentrantReadWriteLock.readLock();
        Lock writeLock = reentrantReadWriteLock.writeLock();
        SharedData sharedData =  new SharedData();

        MyReader myReader = new MyReader( 1, readLock, sharedData);
        MyWriter myWriter0 = new MyWriter( 1, writeLock, sharedData);
        MyReader myReader1 = new MyReader( 2, readLock, sharedData);
        MyReader myReader2 = new MyReader( 3, readLock, sharedData);
        MyReader myReader3 = new MyReader( 3, readLock, sharedData);


        MyWriter myWriter2 = new MyWriter( 2, writeLock, sharedData);

        new Thread( myReader ).start();
        new Thread( myWriter0 ).start();
        new Thread( myReader1 ).start();
        new Thread( myReader2 ).start();
        new Thread( myReader3 ).start();


        //new Thread( myWriter2 ).start();

    }
}
