package com.epam.topic7.task3;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Timofey_Ryuzhov on 5/3/2016.
 */
public class Matryoshka<T extends Containable> implements Containable, Serializable {
    private T innerObject;
    private transient String color;
    private Integer size;
    private double price;

    public Matryoshka(Integer size, double price) {
        this.size = size;
        this.price = price;
        this.color = randomColor();

        if (size.equals(1)) addInner(new BlackPearl(price * 10));
        else addInner(new Matryoshka<Containable>(size - 1, price * 0.9));
    }

    private String randomColor() {
        List<String> colorList = new ArrayList<String>();
        Collections.addAll(colorList, "Red", "Orange", "Yellow", "Green", "Blue", "Blue", "Purple");

        Random random = new Random();

        return colorList.get(random.nextInt(7));
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return color;
    }

    @Override
    public String unpack(String title) {
        return title + "I'm " + color + " matryoushka of size " + size + innerObject.unpack("\n");
    }

    @Override
    public <U extends Containable> void addInner(U innerObject) {
        this.innerObject = (T) innerObject;
    }

    @Override
    public double getCost() {
        return price + innerObject.getCost();
    }
}
