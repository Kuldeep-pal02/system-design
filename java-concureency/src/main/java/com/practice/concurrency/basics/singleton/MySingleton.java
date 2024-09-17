package com.practice.concurrency.basics.singleton;

public class MySingleton {

    private static MySingleton mySingletonInstance;
    private MySingleton(){

    }

    public static MySingleton getInstance(){
        if( mySingletonInstance == null ){
            synchronized ( MySingleton.class) {
                if (mySingletonInstance == null) {
                    mySingletonInstance = new MySingleton();
                }
            }
        }
        return mySingletonInstance;
    }
}
