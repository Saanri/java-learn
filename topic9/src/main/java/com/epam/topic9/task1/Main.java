package com.epam.topic9.task1;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 6/7/2016.
 */
/* REQUIRED. Дописать методы согласно TODO
* Проверьте правильность реализации с помощью результатов в консоли
*/
public class Main {
    private static Logger logger = LogFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            createAndRunThreadA();
            waitThreadAtoComplete();
            completeThreadAwithMain();
            runThreadAwithMaxPriority();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // TODO Создать поток ThreadA и запустить обычным образом перед выполнением цикла
    private static void createAndRunThreadA() throws InterruptedException {
        logger.info("createAndRunThreadA");
        Thread thread = new Thread(new ThreadA());
        //write your code below
        thread.start();
        //write your code above
        mainLoop();
    }

    //TODO Модифицировать метод так, чтобы основной поток "ждал" выполнения ThreadA
    private static void waitThreadAtoComplete() throws InterruptedException {
        logger.info("WaitThreadAtoComplete");
        //write your code below
        Thread thread = new Thread(new ThreadA());
        thread.start();
        thread.join();
        //write your code above
        mainLoop();
    }

    //TODO Модифицировать метод так, чтобы ThreadA завершился одновременно с главным потоком
    private static void completeThreadAwithMain() throws InterruptedException {
        logger.info("completeThreadAwithMain");
        //write your code below
        Thread thread = new Thread(new ThreadA());
        thread.setDaemon(true);
        thread.start();
        //write your code above
        mainLoop();
    }

    //TODO Модифицировать метод так, чтобы ThreadA имел максимальный приоритет, а основной (текущий) поток - минимальный приоритет
    private static void runThreadAwithMaxPriority() throws InterruptedException {
        logger.info("runThreadAwithMaxPriority");
        Thread thread = new Thread(new ThreadA(false));
        //write your code below
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        //write your code above
        for (int i = 0; i < 10; i++) {
            logger.info("Main" + i);
        }
    }

    private static void mainLoop() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.info("Main" + i);
            Thread.sleep(100);
        }
    }
}
