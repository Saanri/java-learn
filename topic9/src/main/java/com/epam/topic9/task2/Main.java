package com.epam.topic9.task2;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Timofey_Ryuzhov on 6/7/2016.
 */
/*REQUIRED. SharedResource
Есть общий ресурс - SharedResource, который содержит в себе список уникальных значений - Set.
Каждый поток в цикле должен добавлять в коллекцию ресурса элемент.
После окончания работы программы в коллекции должно оказаться ITERATIONS * THREAD_COUNT элементов
и содержать элементы [1,2,3,4,5,..., ITERATIONS * THREAD_COUNT]
- Необходимо доработать класс SharedResource  и
  обеспечить  потоко-безопасное добавление элементов в коллекцию объекта:
1) с помощью классического подхода (синхронизация)
2) с помощью объектов Lock
- Выполнить задачу с помощью 2-х видов потоков:
1) interface Runnable (runRunnableThreads()) - pay attention to //TO DO Return the same string by CallableThread
2) interface Callable (runCallableThreads())
* */
public class Main {
    public static final int ITERATIONS = 50000;
    public static final int THREAD_COUNT = 20;
    private static Logger logger = LogFactory.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        logger.info("Run RunnableThreads");
        runRunnableThreads();

        logger.info("Run CallableThreads");
        runCallableThreads();
    }

    private static void runCallableThreads() throws InterruptedException {
        List<Future<String>> futureList = new ArrayList<>();

        SharedResource sharedResource = new SharedResource();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < THREAD_COUNT; i++) {
            CallableThread iCallable = new CallableThread("RunnableThread" + i, ITERATIONS);
            iCallable.setShared(sharedResource);

            Future<String> f = executorService.submit(iCallable);
            futureList.add(f);
        }
        executorService.shutdown();

        logger.info("Executor service - shutdown. Result:");

        for (Future<String> future : futureList)
            try {
                logger.info(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        logger.info("One of the threads should increase set size till:" + THREAD_COUNT * ITERATIONS);
    }

    private static void runRunnableThreads() throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        for (int i = 0; i < THREAD_COUNT; i++) {
            RunnableThread iRunnable = new RunnableThread("RunnableThread" + i, ITERATIONS);
            iRunnable.setShared(sharedResource);
            Thread iThread = new Thread(iRunnable);
            try {
                iThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            iThread.start();
        }
        Thread.sleep(500);
        logger.info("One of the threads should increase set size till:" + THREAD_COUNT * ITERATIONS);
    }
}
