package com.practice.concurrency.basics;

public class PrintEvenOdd {
    boolean evenTurn = false;
    synchronized public void printEven(int n) throws InterruptedException {
        for( int even = 2 ; even <=n; even += 2 ){

            while( !evenTurn ){
                wait();
            }
            System.out.println( even );
            evenTurn = !evenTurn;
            notify();
        }
    }
    synchronized public void printOdd( int n) throws InterruptedException {
        for( int odd = 1 ; odd <=n; odd += 2 ){
            while( evenTurn ){
                wait();
            }
            System.out.println( odd );
            evenTurn = !evenTurn;
            notify();
        }
    }
}
