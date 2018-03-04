package com.epam.topic7.task1;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Iurii Talalaev on 23.05.2016.
 */
public class UtilsTest {

    @Test
    public void testToReverseList() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Number> revertList = new ArrayList<Number>();
        Utils.toReverseList(list, revertList);

        assertArrayEquals(revertList.toArray(), new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
    }

    @Test
    public void testCopyGreaterNumbers() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertArrayEquals(Utils.copyGreaterNumbers(list, 5).toArray(), new Integer[]{6, 7, 8, 9});
    }

    @Test
    public void testSetValues() throws Exception {
        List<Map<Integer, String>> mapList = new LinkedList<Map<Integer, String>>();
        Map<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "one");
        map1.put(2, "two");
        map1.put(3, "free");
        mapList.add(map1);

        Map<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(1, "a");
        map2.put(2, "b");
        map2.put(3, "c");
        mapList.add(map2);

        Map<Integer, String> map3 = new HashMap<Integer, String>();
        map3.put(1, "I");
        map3.put(2, "II");
        map3.put(3, "III");
        mapList.add(map3);

        assertTrue(mapList.toString().equals("[{1=one, 2=two, 3=free}, {1=a, 2=b, 3=c}, {1=I, 2=II, 3=III}]"));

        assertArrayEquals(Utils.setValues(mapList, 2, "replaced").toArray(), new String[]{"two", "b", "II"});

        assertTrue(mapList.toString().equals("[{1=one, 2=replaced, 3=free}, {1=a, 2=replaced, 3=c}, {1=I, 2=replaced, 3=III}]"));
    }

    @Test
    public void testCreateObject() throws Exception {
        Object o = Utils.createObject(String.class);
        assertTrue(o.getClass().getSimpleName().equals("String"));
    }

    @Test(expected = InstantiationException.class)
    public void testCreateObjectInstantiationException() throws Exception {
        Utils.createObject(Integer.class);
    }

}