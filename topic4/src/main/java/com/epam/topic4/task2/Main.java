package com.epam.topic4.task2;

import com.epam.topic4.LogFactory;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by Timofey_Ryuzhov on 4/4/2016.
 */
public class Main {

    public static void main(String[] args) {
        LogFactory logFactory = new LogFactory("com.epam.topic4.task2.FixedArrayList");
        Logger logger = logFactory.getLogger();

        FixedArrayList<String> arList = new FixedArrayList<String>(3);
        logger.info("FixedArrayList is Empty = " + arList.isEmpty());

        arList.add("first element");
        logger.info("Added new element: first element");

        logger.info("Size our FixedArrayList = " + arList.size());

        logger.info("FixedArrayList is Empty = " + arList.isEmpty());

        logger.info("FixedArrayList contains <<new element>> = " + arList.contains("new element"));

        arList.add("second element");
        logger.info("Added new element: second element");

        arList.add("third element");
        logger.info("Added new element: third element");

        logger.info("FixedArrayList to Array: " + arList.toArray().toString());

        arList.remove("second element");
        logger.info("Element <<new second element>> deleted. Now size our FixedArrayList = " + arList.size());

        arList.clear();
        logger.info("FixedArrayList cleared. Size our FixedArrayList = " + arList.size());

        arList.addAll(Arrays.asList("new first element", "new second element", "new third element"));
        String str = new String();
        for (int i = 0; i < arList.size(); i++)
            str += " <<" + arList.get(i) + ">>";
        logger.info("FixedArrayList added all, complete. Contained: " + str);

        logger.info("Element in FixedArrayList, with index <1>, set. Old value = " + arList.set(1, "second element with modified") + ", new value = " + arList.get(1));
        str = "";
        for (int i = 0; i < arList.size(); i++)
            str += " <<" + arList.get(i) + ">>";
        logger.info("FixedArrayList contained:" + str);

        arList.remove(1);
        str = "";
        for (int i = 0; i < arList.size(); i++)
            str += " <<" + arList.get(i) + ">>";
        logger.info("Element with index <<1>> removed. FixedArrayList contained:" + str);

        arList.add(1, "added element");
        str = "";
        for (int i = 0; i < arList.size(); i++)
            str += " <<" + arList.get(i) + ">>";
        logger.info("Add new element with index <<1>>. FixedArrayList contained:" + str);
    }
}
