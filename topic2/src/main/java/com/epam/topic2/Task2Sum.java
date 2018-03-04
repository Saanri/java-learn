package com.epam.topic2;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
// Find the sum  of integer values
public class Task2Sum extends AbstractTask {

    //  Required:  use while loop
    //  Only change code below this line
    private int sum(int[] numbers) {
        int res = 0;

        for (int i : numbers)
            res = res + i;

        return res;
    }
    // Only change code above this line

    public static void main(String[] args) {
        Task2Sum ex = new Task2Sum();
        int[] ar = {5, 6, 10}; // equals 21
        logger.info("sum({5,6,10})       || " + ex.sum(ar));
        int[] ar1 = {53, 64, 10}; // equals 127
        logger.info("sum({53, 64, 10})   || " + ex.sum(ar1));
        int[] ar3 = {56, 6, 1000};
        logger.info("sum({56, 6, 1000})  || " + ex.sum(ar3));
        int[] ar4 = {95, 6, -10};
        logger.info("sum({95, 6, -10})   || " + ex.sum(ar4));
    }
}
