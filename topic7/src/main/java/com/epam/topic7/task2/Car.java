package com.epam.topic7.task2;

import java.io.Serializable;

/**
 * Created by Iurii Talalaev on 15.05.2016.
 */
public class Car extends Vehicle implements Serializable {
    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String toString() {
        return "(Car) " + super.getName();
    }

}
