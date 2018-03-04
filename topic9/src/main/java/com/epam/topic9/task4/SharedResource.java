package com.epam.topic9.task4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by Saanri on 26.06.2016.
 */
public class SharedResource {
    private int a = 0;

    public void setA(Lock lock1, Lock lock2) throws InterruptedException {
        lock1.lock();
        try {
            Thread.sleep(300);
            lock2.lock();
            try {
                Thread.sleep(300);
                a++;
            } finally {
                lock2.unlock();
            }
        } finally {
            lock1.unlock();
        }
    }

    public void setAWithoutDeadLock(Lock lock1, Lock lock2) throws InterruptedException {
        if (lock1.tryLock(2, TimeUnit.SECONDS)) {
            Thread.sleep(300);
            try {
                if (lock2.tryLock(2, TimeUnit.SECONDS)) {
                    Thread.sleep(300);
                    try {
                        a++;
                    } finally {
                        lock2.unlock();
                    }
                }
            } finally {
                lock1.unlock();
            }
        }
    }

    public int getA() {
        return a;
    }
}
