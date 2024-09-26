package com.practice.concurrency.basics.sleepingbarber;

import lombok.Data;

import java.util.concurrent.Semaphore;


@Data
public class BarberShop {
    private final Semaphore waitingCustomer;
    private final Semaphore barberReady;
    private final Semaphore accessSeats;
    private int freeChairs;


    public BarberShop(Semaphore waitingCustomer, Semaphore barberReady, Semaphore accessSeats, int freeChairs) {
        this.waitingCustomer = waitingCustomer;
        this.barberReady = barberReady;
        this.accessSeats = accessSeats;
        this.freeChairs = freeChairs;
    }
}
