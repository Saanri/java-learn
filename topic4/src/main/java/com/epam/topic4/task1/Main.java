package com.epam.topic4.task1;

import com.epam.topic4.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 3/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        LogFactory logFactory = new LogFactory("com.epam.topic4.task1.HeroList");
        Logger logger = logFactory.getLogger();
        HeroList heroList = new HeroList();
        logger.info("Generated list: " + heroList.generateList());
        logger.info("Excluded list: " + heroList.everySecondExcluded());
    }
}
