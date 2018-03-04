package com.epam.topic4.task4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Saanri on 16.04.2016.
 */
public class ParkingTest {
    Parking parking;

    @Before
    public void setUp() throws Exception {
        parking = new Parking(3);

        parking.inputCar("1");
        parking.inputCar("2");
    }

    @Test
    public void testInputCar() throws Exception {
        parking.inputCar("3");

        assertEquals(parking.getCarOnPlace("A3"), "3");

        parking.outputCar("1");
        parking.inputCar("4");

        assertEquals(parking.getCarOnPlace("A1"), "4");
    }

    @Test(expected = Parking.NotFreePlaceException.class)
    public void testInputCarNotFreePlace() throws Exception {
        parking.inputCar("3");
        parking.inputCar("4");
    }

    @Test(expected = Parking.CarAlreadyParked.class)
    public void testInputCarCarAlreadyParked() throws Exception {
        parking.inputCar("2");
    }

    @Test
    public void testOutputCar() throws Exception {
        assertEquals(parking.getCarOnPlace("A1"), "1");

        parking.outputCar("1");

        assertNull(parking.getCarOnPlace("A1"));
    }

    @Test(expected = Parking.CarNotFound.class)
    public void testOutputCarCarNotFound() throws Exception {
        parking.outputCar("XX");
    }

    @Test
    public void testGetParkingPlaces() throws Exception {
        String result = parking.getParkingPlaces();

        assertNotNull(result);
    }
}