package com.epam.topic9.task4;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Timofey_Ryuzhov on 6/8/2016.
 */

/*OPTIONAL
* Реализовать приложение, демонстрирующее такое понятие, как DeadLock
* Предложить решение проблемы
* */
public class Main {
    private static Logger logger = LogFactory.getLogger(Main.class.getName());

    private static final Boolean needDeadLock = true; // !!!!!!!! change the value of this variable

    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        List<Lock> lockList = new ArrayList<Lock>();
        lockList.add(new ReentrantLock());
        lockList.add(new ReentrantLock());

        logger.info("Process start in a mode " + (needDeadLock ? "needDeadLock" : "notNeedDeadLock"));

        for (int i = 0; i < lockList.size(); i++) {
            Thread thread = new Thread(new DeadLock(sharedResource, needDeadLock, lockList.get(i), (i + 1) == lockList.size() ? lockList.get(0) : lockList.get(i + 1)));
            thread.start();
        }

    }
}
