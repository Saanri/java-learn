package com.epam.topic7.task3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Iurii Talalaev on 23.05.2016.
 */
public class MatryoshkaTest {
    Containable matryoshka;

    @Before
    public void setUp() throws Exception {
        matryoshka = new Matryoshka(8, 100);
    }

    @Test
    public void testGetSize() throws Exception {
        assertEquals(matryoshka.getSize(),8);
    }

    @Test
    public void testGetName() throws Exception {
        assertNotNull(matryoshka.getName());
    }

    @Test
    public void testUnpack() throws Exception {
        assertNotNull(matryoshka.unpack("title"));
    }

    @Test
    public void testGetCost() throws Exception {
        assertTrue(matryoshka.getCost() == 1047.82969);
    }
}