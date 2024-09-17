package com.practice.concurrency.basics.readerwriterproblem;

import lombok.Data;

@Data
public class SharedData {
    private int sharedData = 0;

    public void incrementSharedData() {
        sharedData++;
    }
}
