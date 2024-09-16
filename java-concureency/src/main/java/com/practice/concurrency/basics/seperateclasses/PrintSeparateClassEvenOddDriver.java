package com.practice.concurrency.basics.seperateclasses;

public class PrintSeparateClassEvenOddDriver {
    public static void main(String[] args) {
        PrintCordinator coordinator = new PrintCordinator( true );
        int n = 100;

        PrintEven printEven = new PrintEven(coordinator);
        PrintOdd printOdd = new PrintOdd(coordinator);

        Thread threadEven = new Thread(() -> {
            try {
                printEven.printEven(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadOdd = new Thread(() -> {
            try {
                printOdd.printOdd(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadEven.start();
        threadOdd.start();
    }
}
