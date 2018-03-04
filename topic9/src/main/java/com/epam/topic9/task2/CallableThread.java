package com.epam.topic9.task2;

import java.util.concurrent.Callable;

/**
 * Created by Timofey_Ryuzhov on 6/8/2016.
 */
public class CallableThread implements Callable<String> {
    private String name;
    private int iterations;
    private SharedResource shared = null;

    public CallableThread(String name, int iterations) {
        this.name = name;
        this.iterations = iterations;
    }

    @Override
    public String call() throws Exception {
        int res = 0;
        for (int i = 0; i < iterations; i++) {
            res = shared.addUsingLock();
        }

        return "Thread: " + name + " incremented shared to " + res + " and sharedSize is now : " + shared.getSize();
    }

    public void setShared(SharedResource shared) {
        this.shared = shared;
    }

}
