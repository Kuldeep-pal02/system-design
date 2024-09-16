package com.practice.concurrency.basics.seperateclasses;


import lombok.Data;

@Data
public class PrintCordinator {
    private boolean evenTurn;

    public PrintCordinator( boolean evenTurn){
        this.evenTurn = evenTurn;
    }
}
