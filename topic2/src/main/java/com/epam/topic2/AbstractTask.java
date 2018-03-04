package com.epam.topic2;

import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
public abstract class AbstractTask {
    protected static Logger logger = null;

    public AbstractTask() {
        String name = this.getClass().getName();
        System.setProperty("log.filename", String.format("log/%s.out", name));
        System.setProperty("test.class", name);
        logger = Logger.getLogger(name);
    }
}
