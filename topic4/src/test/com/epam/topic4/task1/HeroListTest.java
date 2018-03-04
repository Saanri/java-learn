package com.epam.topic4.task1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by Saanri on 16.04.2016.
 */
@RunWith(JUnit4.class)
public class HeroListTest {
    HeroList heroList;

    @Before
    public void setUp() throws Exception {
        heroList = new HeroList();
    }

    @Test
    public void testGenerateList() throws Exception {
        assertNotNull(heroList.generateList());
    }

    @Test
    public void testEverySecondExcluded() throws Exception {
        ArrayList<String> heroList = new ArrayList<String>();
        Collections.addAll(heroList, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        this.heroList.setHeroList(heroList);

        String resultStr = this.heroList.everySecondExcluded();

        assertTrue(resultStr.equals("[7]"));
    }

    @Test(expected = NullPointerException.class)
    public void testEverySecondExcludedInputNull() throws Exception {
        heroList.everySecondExcluded();
    }

}