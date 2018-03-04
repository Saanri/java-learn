package com.epam.topic4;

import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
public class LogFactory {
    protected Logger logger = null;

    public LogFactory(String name) {
        System.setProperty("log.filename", String.format("log/%s.out", name));
        System.setProperty("test.class", name);
        logger = org.apache.log4j.Logger.getLogger(name);
    }

    public Logger getLogger() {
        return logger;
    }
}
