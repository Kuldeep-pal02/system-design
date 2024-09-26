package com.practice.concurrency.basics.sleepingbarber;

import java.util.concurrent.Semaphore;

public class SleepingBarberDriver {
    public static void main(String[] args) {
        int numChairs =5;
        BarberShop shop = new BarberShop(  new Semaphore(0), new Semaphore(1 ), new Semaphore( 0) , numChairs) ;
        new Thread( new Barber( shop)).start();

        int customerId =0;
        while( customerId <10 ){
            new Thread( new Customers( customerId++,shop)).start();
        }
    }
}
