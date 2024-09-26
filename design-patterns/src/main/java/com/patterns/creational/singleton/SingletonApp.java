package com.patterns.creational.singleton;

public class SingletonApp {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println( singleton1 == singleton );
    }
}
