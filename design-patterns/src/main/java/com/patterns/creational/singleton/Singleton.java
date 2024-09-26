package com.patterns.creational.singleton;

public class Singleton {
    public static Singleton INSTANCE;

    private Singleton(){
        try{
            Thread.sleep( 3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Singleton getInstance(){
        if( INSTANCE == null ){
            synchronized ( Singleton.class){
                if( INSTANCE == null ){
                    INSTANCE = new Singleton();
                }
            }
        }
        return  INSTANCE;
    }
}
