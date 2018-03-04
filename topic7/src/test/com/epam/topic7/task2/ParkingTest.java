package com.epam.topic7.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Iurii Talalaev on 23.05.2016.
 */
public class ParkingTest {
    Parking<Place, Vehicle> parking;

    @Before
    public void setUp() throws Exception {
        List<Place> placeList = new ArrayList<Place>();
        for (int i = 0; i < 5; i++) placeList.add(new Place(i, "A" + i));

        parking = new Parking<Place, Vehicle>(placeList);

        Car car1 = new Car();
        car1.setName("Car1");

        parking.inputVehicle(car1);
    }

    @Test
    public void testInputVehicle() throws Exception {
        Car car2 = new Car();
        car2.setName("Car2");
        parking.inputVehicle(car2);
        assertTrue(parking.getVehicleOnPlace(parking.getPlaceOnId(1)).getName().equals("Car2"));

        Bus bus1 = new Bus();
        bus1.setName("Bus1");
        parking.inputVehicle(bus1);
        assertTrue(parking.getVehicleOnPlace(parking.getPlaceOnId(2)).getName().equals("Bus1"));
        assertTrue(parking.getVehicleOnPlace(parking.getPlaceOnId(3)).getName().equals("Bus1"));
        assertTrue(parking.getVehicleOnPlace(parking.getPlaceOnId(4)).getName().equals("Bus1"));
    }

    @Test
    public void testInputVehicleNotFreePlace() throws Exception {
        Bus bus1 = new Bus();
        bus1.setName("Bus1");
        Bus bus2 = new Bus();
        bus2.setName("Bus2");
        parking.inputVehicle(bus1);
        try {
            parking.inputVehicle(bus2);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Exception (inputVehicle): Not free places"));
        }

        parking.outputVehicle(bus1);

        Truck truck1 = new Truck();
        truck1.setName("Truck1");
        parking.inputVehicle(truck1);

        Car car2 = new Car();
        car2.setName("Car2");
        parking.inputVehicle(car2);

        parking.outputVehicle(truck1);

        try {
            parking.inputVehicle(bus2);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Exception (inputVehicle): Not free places"));
        }
    }

    @Test
    public void testInputVehicleVehicleAlreadyParked() throws Exception {
        Car car2 = new Car();
        car2.setName("Car2");
        parking.inputVehicle(car2);

        try {
            parking.inputVehicle(car2);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Exception (inputVehicle): Vehicle already parked"));
        }

        Car car3 = new Car();
        car3.setName("Car2");
        try {
            parking.inputVehicle(car3);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Exception (inputVehicle): Vehicle with name <<" + car3.getName() + ">>, already parked"));
        }
    }

    @Test
    public void testOutputVehicle() throws Exception {
        assertTrue(parking.getVehicleOnPlace(parking.getPlaceOnId(0)).getName().equals("Car1"));

        parking.outputVehicle(parking.getVehicleOnPlace(parking.getPlaceOnId(0)));

        assertNull(parking.getVehicleOnPlace(parking.getPlaceOnId(0)));
    }

    @Test
    public void testOutputVehicleVehicleNotFound() throws Exception {
        Car car1 = (Car) parking.getVehicleOnPlace(parking.getPlaceOnId(0));

        parking.outputVehicle(car1);
        try {
            parking.inputVehicle(car1);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals("Exception (outputVehicle): Vehicle not found"));
        }
    }

    @Test
    public void testGetParkingPlaces() throws Exception {
        String result = parking.getParkingPlaces();

        assertNotNull(result);
    }
}