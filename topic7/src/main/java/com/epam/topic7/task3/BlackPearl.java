package com.epam.topic7.task3;

import java.io.Serializable;

/**
 * Created by Timofey_Ryuzhov on 5/3/2016.
 */
public class BlackPearl implements Containable, Serializable {

    private double price;

    public BlackPearl(double price) {
        this.price = price;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String getName() {
        return "BlackPearl";
    }

    @Override
    public String unpack(String title) {
        return title + "Here I'm the BlackPearl";
    }

    @Override
    public <T extends Containable> void addInner(T innerObject) {

    }

    @Override
    public double getCost() {
        return price;
    }
}
