package com.epam.topic2;

/**
 * Created by Timofey_Ryuzhov on 3/20/2016.
 */
//Return the lowest index at which a value (second argument) should be inserted into an
//array (first argument) once it has been sorted. For example, getIndex({1,2,3,4}, 1.5) should return 1
//because it is greater than 1 (index 0), but less than 2 (index 1). Likewise, getIndex({20,3,5}, 19)
//should return 2 because once the array has been sorted it will look like {3,5,20} and 19 is less than 20 (index 2)
//and greater than 5 (index 1).
public class Task7ArrIndex extends AbstractTask {
    //  Tip: use Arrays class
    //  Only change code below this line
    private int getIndex(int[] arr, int number) {
        int res = arr.length;

        for (int i = 0; i < arr.length; i++) {
            for (int k = i; k < arr.length; k++) {
                int tmp;

                if (arr[i] > arr[k]) {
                    tmp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = tmp;
                }
            }

            if (number <= arr[i]) {
                res = i;
                break;
            }
        }

        return res;
    }
    // Only change code above this line

    public static void main(String[] args) {
        Task7ArrIndex ex = new Task7ArrIndex();
        int[] arr1 = {10, 20, 30, 40, 50};
        logger.info("getIndex({10, 20, 30, 40, 50}, 35)   || " + ex.getIndex(arr1, 35));  // equals 3
        int[] arr2 = {3, 10, 5};
        logger.info("getIndex({3, 10, 5}, 3)              || " + ex.getIndex(arr2, 3));  //equals 0
        int[] arr3 = {2, 20, 10};
        logger.info("getIndex({2, 20, 10}, 19)            || " + ex.getIndex(arr3, 19)); //equals ?
        int[] arr4 = {2, 5, 10};
        logger.info("getIndex({2, 5, 10}, 15)             || " + ex.getIndex(arr4, 15)); //equals ?
    }
}

