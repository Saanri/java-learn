package com.epam.topic4.task2;

import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Saanri on 16.04.2016.
 */
public class FixedArrayListTest {

    FixedArrayList<String> fixedArrayList;

    @Before
    public void setUp() throws Exception {
        fixedArrayList = new FixedArrayList<String>(3);
    }

    @Test
    public void testSize() throws Exception {
        assertTrue(fixedArrayList.size() >= 0);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(fixedArrayList.isEmpty());

        fixedArrayList.add("element1");

        assertFalse(fixedArrayList.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");

        assertTrue(fixedArrayList.contains("element1"));
        assertFalse(fixedArrayList.contains("element4"));
    }

    @Test
    public void testToArray() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");

        Object[] objects = fixedArrayList.toArray();

        assertTrue(objects.length == 2);
        assertTrue(objects[0] == "element1");
        assertTrue(objects[1] == "element2");
    }

    @Test
    public void testAdd() throws Exception {
        assertTrue(fixedArrayList.size() == 0);
        assertTrue(fixedArrayList.add("element1"));
        assertTrue(fixedArrayList.add("element2"));
        assertTrue(fixedArrayList.add("element3"));
        assertTrue(fixedArrayList.size() == 3);
        assertFalse(fixedArrayList.add("element4"));
    }

    @Test
    public void testRemove() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");

        int beginSize = fixedArrayList.size();

        assertTrue(fixedArrayList.remove("element2"));
        assertTrue(fixedArrayList.size() < beginSize);

        assertFalse(fixedArrayList.remove("element2"));
    }

    @Test
    public void testAddAll() throws Exception {
        assertTrue(fixedArrayList.addAll(Arrays.asList("element1", "element2")));
        assertTrue(fixedArrayList.addAll(Arrays.asList("element3", "element4")));
        assertTrue(fixedArrayList.get(2).equals("element3"));
        assertTrue(fixedArrayList.size() == 3);
        assertFalse(fixedArrayList.addAll(Arrays.asList("element4")));
    }

    @Test
    public void testClear() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");
        assertTrue(fixedArrayList.size() == 3);
        fixedArrayList.clear();
        assertTrue(fixedArrayList.size() == 0);
    }

    @Test
    public void testGet() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");

        assertTrue(fixedArrayList.get(1).equals("element2"));
    }

    @Test(expected = NotImplementedException.class)
    public void testSet() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");

        assertTrue(fixedArrayList.set(1, "element4").equals("element2"));
        assertTrue(fixedArrayList.get(1).equals("element4"));

        fixedArrayList.set(3, "element5");
    }

    @Test(expected = NotImplementedException.class)
    public void testAdd1() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");

        fixedArrayList.add(1, "element4");
        assertTrue(fixedArrayList.get(1).equals("element4"));
        assertTrue(fixedArrayList.get(2).equals("element2"));

        fixedArrayList.add(3, "element5");
    }

    @Test
    public void testRemove1() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");

        assertTrue(fixedArrayList.remove(1).equals("element2"));
        assertNull(fixedArrayList.remove(3));
    }

    @Test
    public void testIndexOf() throws Exception {
        fixedArrayList.add("element1");
        fixedArrayList.add("element2");
        fixedArrayList.add("element3");

        assertTrue(fixedArrayList.indexOf("element2") == 1);
        assertTrue(fixedArrayList.indexOf("element4") == -1);
    }
}