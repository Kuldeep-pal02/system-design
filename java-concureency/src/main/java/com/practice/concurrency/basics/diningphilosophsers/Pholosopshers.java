package com.practice.concurrency.basics.diningphilosophsers;

import javax.swing.*;
import java.util.concurrent.Semaphore;

public class Pholosopshers implements Runnable {

    private final int id;
    private final Semaphore leftChopstick;
    private final Semaphore rightChopstick;

    public Pholosopshers(int id, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }


    @Override
    public void run() {
        try{
            while (true){
                think();
                pickUpChopsticks();
                eat();
                putDownChopsticks();
            }
        }catch (Exception e ){
            System.out.println( "Exception Occured ::"+ Thread.currentThread().getName());
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000)); // Simulate thinking
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep((long) (Math.random() * 1000)); // Simulate eating
    }
    private void putDownChopsticks() {
        leftChopstick.release();
        rightChopstick.release();
        System.out.println("Philosopher " + id + " put down both chopsticks.");
    }

    private void pickUpChopsticks() throws InterruptedException {
        // Philosopher 0 picks up right chopstick first to avoid deadlock
        if (id == 0) {
            rightChopstick.acquire();
            System.out.println("Philosopher " + id + " picked up right chopstick.");
            leftChopstick.acquire();
            System.out.println("Philosopher " + id + " picked up left chopstick.");
        } else {
            leftChopstick.acquire();
            System.out.println("Philosopher " + id + " picked up left chopstick.");
            rightChopstick.acquire();
            System.out.println("Philosopher " + id + " picked up right chopstick.");
        }
    }
}
