package com.epam.topic4.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Saanri on 16.04.2016.
 */
public class FirstElementTypeListTest {
    FirstElementTypeList firstElementTypeList;

    @Before
    public void setUp() throws Exception {
        firstElementTypeList = new FirstElementTypeList();
    }

    @Test
    public void testAdd() throws Exception {
        ArrayList<Object> arrayList = firstElementTypeList.getArrayList();
        assertEquals(arrayList, null);

        firstElementTypeList.add(1);
        firstElementTypeList.add(2);
        firstElementTypeList.add(3);

        arrayList = firstElementTypeList.getArrayList();

        assertEquals(arrayList.size(), 3);
        assertEquals(arrayList.get(0), 1);
        assertEquals(arrayList.get(1), 2);
        assertEquals(arrayList.get(2), 3);
    }

    @Test(expected = Exception.class)
    public void testAddException() throws Exception {
        firstElementTypeList.add("строка");
        firstElementTypeList.add(20);
    }
}