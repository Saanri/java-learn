package com.epam.topic7.task1;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Timofey_Ryuzhov on 5/8/2016.
 */
// Демонстрация работы методов или реализовать unit-tests
public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = LogFactory.getLogger("com.epam.topic7");

        logger.info("Check <<toReverseList>>");

        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        logger.info("       1. List created: " + list);

        List<Number> revertList = new ArrayList<Number>();
        Utils.toReverseList(list, revertList);

        logger.info("       2. List reverted: " + revertList);

        logger.info("Check <<copyGreaterNumbers>>");
        logger.info("       1. Using list :  " + list);
        logger.info("       2. List modified: " + Utils.copyGreaterNumbers(list,5));

        logger.info("Check <<setValues>>");
        List<Map<Integer,String>> mapList = new LinkedList<Map<Integer, String>>();
        Map<Integer,String> map1 = new HashMap<Integer, String>();
        map1.put(1,"one");
        map1.put(2,"two");
        map1.put(3,"free");
        mapList.add(map1);

        Map<Integer,String> map2 = new HashMap<Integer, String>();
        map2.put(1,"a");
        map2.put(2,"b");
        map2.put(3,"c");
        mapList.add(map2);

        Map<Integer,String> map3 = new HashMap<Integer, String>();
        map3.put(1,"I");
        map3.put(2,"II");
        map3.put(3,"III");
        mapList.add(map3);

        logger.info("       1. List with map, created:  " + mapList);
        logger.info("       2. Method <<setValues>> returned:  " + Utils.setValues(mapList,2,"replaced"));
        logger.info("       3. List modified:  " + mapList);

        logger.info("Check <<createObject>>");
        logger.info("       1. Object created:  " + Utils.createObject(String.class).getClass());
    }
}
