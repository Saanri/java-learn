package com.epam.topic9.task2;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 6/7/2016.
 */
public class RunnableThread implements Runnable {
    private Logger logger = LogFactory.getLogger(getClass().getName());
    private String name;
    private int iterations;
    private SharedResource shared = null;

    public RunnableThread(String name, int iterations) {
        this.name = name;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        int res = 0;
        for (int i = 0; i < iterations; i++) {
            res = shared.addWithClassicBlock();
        }
        logger.info("Thread: " + name + " incremented shared to " + res + " and sharedSize is now : " + shared.getSize());
    }

    public void setShared(SharedResource shared) {
        this.shared = shared;
    }
}
