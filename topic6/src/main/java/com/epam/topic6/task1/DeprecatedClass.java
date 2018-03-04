package com.epam.topic6.task1;

import com.epam.topic6.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */

public class DeprecatedClass {

    private Logger logger = LogFactory.getLogger(getClass().getName());

    @Deprecated
    public void deprecatedMethod() {
        logger.info("I'm a deprecated method");
    }

    public void notDeprecatedMethod() {
        logger.info("I'm not a deprecated method");
    }
}
