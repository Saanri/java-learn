package com.epam.topic6.task3;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
public class RandomField {
    @RandomInt(min = 5, max = 10)
    private int a;

    private int b;

    @RandomInt(min = 50, max = 100)
    private int c;

    @Override
    public String toString() {
        return "a = " + a + ", b = " + b + ", c = " + c;
    }
}
