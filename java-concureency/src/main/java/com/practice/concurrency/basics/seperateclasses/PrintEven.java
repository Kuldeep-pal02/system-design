package com.practice.concurrency.basics.seperateclasses;

public class PrintEven {

    private PrintCordinator printCordinator;

    public PrintEven( PrintCordinator printCordinator ){
        this.printCordinator = printCordinator;
    }
    public void printEven(int n) throws InterruptedException {
        synchronized ( printCordinator ){
            for( int even = 0 ; even <=n; even += 2 ){

                while( !printCordinator.isEvenTurn() ){
                    printCordinator.wait();
                }
                System.out.println( even );
                printCordinator.setEvenTurn( !printCordinator.isEvenTurn() );
                printCordinator.notify();
            }
        }

    }
}
