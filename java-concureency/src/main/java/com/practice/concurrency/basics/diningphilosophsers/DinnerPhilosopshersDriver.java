package com.practice.concurrency.basics.diningphilosophsers;

import javax.swing.*;
import java.util.concurrent.Semaphore;

public class DinnerPhilosopshersDriver {
    public static void main(String[] args) {
        Semaphore[] chopsticks = new Semaphore[ 5 ];
        for( int i=0;i< 5;i++){
            chopsticks[i] = new Semaphore( 1 );
        }
        Pholosopshers[] pholosopshers = new Pholosopshers[5];
        for( int i=0;i<5;i++){
            pholosopshers[i] = new Pholosopshers( i , chopsticks[i],chopsticks[(i+1 )%5]);
            new Thread( pholosopshers[i]).start();
        }
    }
}
