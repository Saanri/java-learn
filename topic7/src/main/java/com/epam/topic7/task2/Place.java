package com.epam.topic7.task2;

import java.io.Serializable;

/**
 * Created by Timofey_Ryuzhov on 5/8/2016.
 */
public class Place implements Serializable {
    private Integer id;
    private String name;

    public Place(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
