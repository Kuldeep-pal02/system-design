package com.practice.concurrency.basics.seperateclasses;

public class PrintOdd {


    private PrintCordinator printCordinator;

    public PrintOdd( PrintCordinator printCordinator ){

        this.printCordinator = printCordinator;
    }
    public void printOdd( int n) throws InterruptedException {
        synchronized ( printCordinator ){
            for( int odd = 1 ; odd <=n; odd += 2 ){
                while( printCordinator.isEvenTurn() ){
                    printCordinator.wait();
                }
                System.out.println( odd );
                printCordinator.setEvenTurn( !printCordinator.isEvenTurn() );
                printCordinator.notify();
            }
        }

    }
}
