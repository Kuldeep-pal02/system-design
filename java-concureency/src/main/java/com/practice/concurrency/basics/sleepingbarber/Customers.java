package com.practice.concurrency.basics.sleepingbarber;

import java.util.concurrent.Semaphore;

public class Customers implements Runnable{

    private final int id;
    private final BarberShop barberShop;

    public Customers(int id, BarberShop barberShop) {
        this.id = id;
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        while( true ){
            try{
                barberShop.getAccessSeats().acquire();
                if( barberShop.getFreeChairs() > 0 ){
                    barberShop.setFreeChairs(barberShop.getFreeChairs() -1 );
                    barberShop.getWaitingCustomer().release();
                    barberShop.getAccessSeats().release();
                    barberShop.getBarberReady().acquire();
                    getHairCut();
                }else{
                    System.out.println( "No seat avialble for customer hence returing customerId : "+ this.id);
                    barberShop.getAccessSeats().release();
                }
            }catch (Exception e){
                System.out.println( "Customer Exception for customer id "+ this.id +" ");
            }
        }
    }
    void getHairCut() throws InterruptedException {
        System.out.println( "Customer id "+this.id + " is getting hair cut : STARTED");
        Thread.sleep((long) (Math.random()*1000));
        System.out.println( "Customer id "+this.id + " is getting hair cut : FINISHED");

    }
}
