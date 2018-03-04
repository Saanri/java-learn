package com.epam.topic6.task3;

import com.epam.topic6.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
/*Implement RandomIntFactory*/
//OPTIONAL TASK
public class Main {
    public static void main(String[] args) {
        Logger log = LogFactory.getLogger(RandomField.class.getName());
        log.info(RandomIntFactory.getInstance());
    }
}
