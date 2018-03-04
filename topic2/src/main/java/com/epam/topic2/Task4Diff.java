package com.epam.topic2;

import java.util.Arrays;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
//  Compare two arrays and return a new array with any items only found in one of the two given arrays,
//  but not both. In other words, return the symmetric difference of the two arrays.
public class Task4Diff extends AbstractTask {

    // Required: don't use List or Map
    // Only change code below this line
    public int[] diff(int[] arr1, int[] arr2) {
        int[] tmpArray = new int[arr1.length + arr2.length];  // массив размерностью равный двум обрабатываемым массивам
        int c = 0;                                          // индекс для работы с tmpArray
        int flag = 0;                                       // флаг

        for (int i = 0; i < arr1.length; i++) {
            for (int n = 0; n < arr2.length; n++) {
                if (arr1[i] == arr2[n]) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                flag = 0;
            } else {
                tmpArray[c] = arr1[i];
                c++;
            }
        }


        for (int i = 0; i < arr2.length; i++) {
            for (int n = 0; n < arr1.length; n++) {
                if (arr2[i] == arr1[n]) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                flag = 0;
            } else {
                tmpArray[c] = arr2[i];
                c++;
            }
        }

        int[] res = new int[c];

        for (int i = 0; i < c; i++)
            res[i] = tmpArray[i];

        return res;
    }
    // Only change code above this line

    public static void main(String[] args) {
        Task4Diff ex = new Task4Diff();
        int[] ar = {1, 2, 3, 5};
        int[] ar1 = {1, 2, 3, 4, 5};
        logger.info("diff({1, 2, 3, 5},{1, 2, 3, 4, 5})                        || " + Arrays.toString(ex.diff(ar, ar1))); // equals [4]
        int[] ar2 = {1, 2, 3, 5, 10, 100};
        int[] ar3 = {1, 2, 3, 4, 5, 1000, 40};
        logger.info("diff({1, 2, 3, 5, 10, 100},{1, 2, 3, 4, 5, 1000, 40})     || " + Arrays.toString(ex.diff(ar2, ar3))); // equals [4, 10, 1000, 40]
        int[] ar4 = {10, 100};
        int[] ar5 = {1, 2, 3, 4, 5, 10, 40};
        logger.info("diff({10, 100},{1, 2, 3, 4, 5, 10, 40})                   || " + Arrays.toString(ex.diff(ar4, ar5))); // equals ?
        int[] ar6 = {1};
        int[] ar7 = {1};
        logger.info("diff({1},{1})                                             || " + Arrays.toString(ex.diff(ar6, ar7))); // equals ?
    }
}
