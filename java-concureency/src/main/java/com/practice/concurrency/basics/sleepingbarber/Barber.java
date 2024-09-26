package com.practice.concurrency.basics.sleepingbarber;

import java.util.concurrent.Semaphore;

public class Barber implements Runnable{

    private final BarberShop barberShop;

    public Barber(BarberShop barberShop ) {
        this.barberShop = barberShop;
    }


    @Override
    public void run() {

        while ( true ){
            try{
                barberShop.getWaitingCustomer().acquire();

                barberShop.getAccessSeats().acquire();
                barberShop.setFreeChairs(barberShop.getFreeChairs() +1 );

                System.out.println("Barber is ready to cut hairs, free chairs are "+ barberShop.getFreeChairs());
                barberShop.getAccessSeats().release();
                barberShop.getBarberReady().release();
                this.cutHair();
            }catch ( Exception e){
                System.out.println( "Exception occured in Barber class while cutting hain");
            }finally {

            }
        }

    }
    void cutHair( ) throws InterruptedException {
        System.out.println( " Barber is cutting hair : STARTED");
        Thread.sleep((long) (Math.random()*100));
        System.out.println( "Barber FINISHED cutting hair ");
    }
}
