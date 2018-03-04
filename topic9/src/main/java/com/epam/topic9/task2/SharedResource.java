package com.epam.topic9.task2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Timofey_Ryuzhov on 6/7/2016.
 */
public class SharedResource {
    private Set<Integer> set = new HashSet<>();
    private Integer lastAddedId = 0;

    final Lock lock = new ReentrantLock();

    /**
     * @return last added element
     */
    public synchronized int addWithClassicBlock() {
        set.add(++lastAddedId);
        return lastAddedId;
    }

    /**
     * @return Last added element
     */
    public int addUsingLock() {
        final Lock lock = this.lock;
        lock.lock();
        try {
            int res = ++lastAddedId;
            set.add(res);
            return res;
        } finally {
            lock.unlock();
        }
    }

    public Integer getSize() {
        return set.size();
    }

}
