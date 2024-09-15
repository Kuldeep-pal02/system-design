package com.practice.concurrency.basics;

public class EvenOddDriver {
    public static void main(String[] args) {
        PrintEvenOdd printEvenOdd = new PrintEvenOdd();
        int n = 100;
        Thread threadEven = new Thread(() -> {
            try {
                printEvenOdd.printEven( n );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadOdd = new Thread(() -> {
            try {
                printEvenOdd.printOdd( n );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadEven.start();
        threadOdd.start();
    }

}
