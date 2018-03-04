package com.epam.topic7.task2;

import java.io.Serializable;

/**
 * Created by Timofey_Ryuzhov on 5/8/2016.
 */
public abstract class Vehicle implements Serializable {
    public abstract int getSize();

    @Override
    public abstract String toString();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
