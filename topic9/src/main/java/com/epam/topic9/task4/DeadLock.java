package com.epam.topic9.task4;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

import java.util.concurrent.locks.Lock;

/**
 * Created by Timofey_Ryuzhov on 6/8/2016.
 */
public class DeadLock implements Runnable {
    private static Logger logger = LogFactory.getLogger(DeadLock.class.getName());

    SharedResource sharedResource;
    Boolean needDeadLock;
    Lock lock1;
    Lock lock2;

    public DeadLock(SharedResource sharedResource, Boolean needDeadLock, Lock lock1, Lock lock2) {
        this.sharedResource = sharedResource;
        this.needDeadLock = needDeadLock;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        try {
            if (needDeadLock)
                sharedResource.setA(lock1, lock2);
            else
                sharedResource.setAWithoutDeadLock(lock1, lock2);
        } catch (InterruptedException e) {
            logger.info("InterruptedException: " + e.getMessage());
        }
    }
}
