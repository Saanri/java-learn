package com.epam.topic6.task4;

import com.epam.topic6.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
public class OrderedMethod {
    private Logger logger = LogFactory.getLogger(getClass().getName());

    @Last
    public void lastMethod() {
        logger.info("Last method invocation");
    }

    @Last
    public void lastMethod1() {
        logger.info("Last method1 invocation");
    }

    @Invoke(priority = 2)
    public void anotherMethod1() {
        logger.info("another method 1 invocation");
    }

    @Invoke(priority = 1)
    public void anotherMethod2() {
        logger.info("another method 2 invocation");
    }

    @Invoke(priority = 1)
    public void anotherMethod3() {
        logger.info("another method 3 invocation");
    }

    @Invoke(priority = 3)
    public void anotherMethod4() {
        logger.info("another method 4 invocation");
    }

    public void unknownMethod1() {
        logger.info("unknown method 1 invocation");
    }

    public void unknownMethod2() {
        logger.info("unknown method 2 invocation");
    }

    @First
    public void firstMethod() {
        logger.info("First method invocation");
    }

    @First
    public void firstMethod1() {
        logger.info("First method1 invocation");
    }


}
