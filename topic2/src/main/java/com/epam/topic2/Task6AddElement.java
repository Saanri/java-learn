package com.epam.topic2;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
// Write a function that adds different object in a proper way: numbers as numbers, strings as strings
public class Task6AddElement extends AbstractTask {

    //  Tips: instanceof, type casting, if-else, for-loop
//  Only change code below this line
    private Object add(Object[] obj) {
        Object res = null;

        if (obj instanceof Integer[]) {
            int intRes = 0;

            for (Object i : obj)
                if (i != null) intRes += Integer.parseInt(i.toString());

            res = intRes;
        } else if (obj instanceof String[]) {
            String strRes = "";

            for (Object i : obj)
                if (i != null) strRes += i.toString();

            res = strRes;
        } else if (obj instanceof Double[]) {
            double dblRes = 0;

            for (Object i : obj)
                if (i != null) dblRes += Double.parseDouble(i.toString());

            res = dblRes;
        }

        return res;
    }
    // Only change code above this line

    public static void main(String[] args) {
        Task6AddElement ex = new Task6AddElement();
        Integer[] ar = {5, 6, 10};
        logger.info("add({5,6,10})                   || " + ex.add(ar)); // equals 21
        Integer[] ar1 = {53, 64, 10, 115};
        logger.info("add({53, 64, 10, 115})          || " + ex.add(ar1)); //equals ?
        Integer[] ar2 = {5, 6, null};
        logger.info("add({5, 6, null})               || " + ex.add(ar2)); //equals 11
        String[] ar3 = {"hello ", "sly ", "fox"};
        logger.info("add({hello , sly , fox})        || " + ex.add(ar3)); //equals  "hello sly fox"
        String[] ar4 = {"hello ", null, "fox"};
        logger.info("add({hello , null, fox})        || " + ex.add(ar4)); //equals ?
        Double[] ar5 = {0.3, null, 34343.3939483};
        logger.info("add({0.3, null, 34343.3939483}) || " + ex.add(ar5)); //equals ?
    }
}
