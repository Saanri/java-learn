package com.epam.topic7.task2;

import java.io.Serializable;

/**
 * Created by Iurii Talalaev on 15.05.2016.
 */
public class Bus extends Vehicle implements Serializable {
    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public String toString() {
        return "(Bus) " + super.getName();
    }

}
