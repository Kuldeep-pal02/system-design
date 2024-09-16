package com.practice.concurrency.basics.producerconsumer;

public interface BufferForProducerConsumer {
    void produce(int number) throws InterruptedException;

    void consume() throws InterruptedException;
}
