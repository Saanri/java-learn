package com.epam.topic4.task3;

import com.epam.topic4.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 4/4/2016.
 */
public class Main {

    public static void main(String[] args) {
        LogFactory logFactory = new LogFactory("com.epam.topic4.task3.FirstElementTypeList");
        Logger logger = logFactory.getLogger();

        FirstElementTypeList myList = new FirstElementTypeList();
        Integer number = new Integer(10);
        try {
            myList.add(number);
            logger.info("В myList добавлен новый элемент с типом " + number.getClass().getSimpleName() + ", равный <<" + number.toString() + ">>");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        try {
            myList.add("Illegal element");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        number = new Integer(20);
        try {
            myList.add(number);
            logger.info("В myList добавлен новый элемент с типом " + number.getClass().getSimpleName() + ", равный <<" + number.toString() + ">>");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
