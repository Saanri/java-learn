package com.epam.topic6;

import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
public class LogFactory {

    protected static Logger logger = null;

    public static Logger getLogger(String name) {
        System.setProperty("log.filename", String.format("log/%s.out", name));
        System.setProperty("test.class", name);
        logger = Logger.getLogger(name);
        return logger;
    }
}
