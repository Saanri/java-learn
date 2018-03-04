package com.epam.topic9.task1;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 6/7/2016.
 */
public class ThreadA implements Runnable {
    private Logger logger = LogFactory.getLogger(getClass().getName());
    private boolean isSleeping = true;

    public ThreadA(boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    public ThreadA() {

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            logger.info("A" + i);
            try {
                if (isSleeping)
                    Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
