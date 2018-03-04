package com.epam.topic2;

/**
 * Created by Timofey_Ryuzhov on 3/19/2016.
 */
// Find the factorial of a number
// Factorials are often represented with the shorthand notation n!
// For example: 5! = 1 * 2 * 3 * 4 * 5 = 120
public class Task1Factorial extends AbstractTask {

    //  Only change code below this line
    private long factorial(int number) {
        if (number == 0) return 1;

        long res = 1;

        for (int i = 2; i <= number; i++)
            res = res * i;

        return res;
    }
    // Only change code above this line

    public static void main(String[] args) {
        Task1Factorial ex = new Task1Factorial();
        logger.info("factorial(0)    || " + ex.factorial(0));   //equals 1
        logger.info("factorial(5)    || " + ex.factorial(5));   //equals 120
        logger.info("factorial(10)   || " + ex.factorial(10));  //equals ?
        logger.info("factorial(20)   || " + ex.factorial(20));  //equals ?
    }
}
