package com.epam.topic9.task3;

import com.epam.topic7.LogFactory;
import com.epam.topic7.task2.Place;
import com.epam.topic7.task2.Vehicle;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

/**
 * Created by Timofey_Ryuzhov on 6/8/2016.
 */
public class ParkingThread<V extends Vehicle> implements Callable<String> {
    private static Logger logger = LogFactory.getLogger(Main.class.getName());

    private String name;
    private Parking<Place, Vehicle> parking;
    private int sleepLong;

    private ArrayList<V> vehicleList;

    public ParkingThread(Parking<Place, Vehicle> parking, Class clazz, ArrayList<String> plateList) {
        this.name = clazz.getSimpleName() + " parking thread";
        this.parking = parking;
        this.sleepLong = clazz.getSimpleName().equals("Car") ? 500 : clazz.getSimpleName().equals("Truck") ? 1000 : clazz.getSimpleName().equals("Bus") ? 1500 : 0;
        this.vehicleList = new ArrayList<V>();

        ArrayList<String> plates = plateList;

        for (String s : plates) {
            try {
                V vehicle = (V) clazz.newInstance();
                vehicle.setName(s);
                vehicleList.add(vehicle);
            } catch (Exception e) {
                logger.info(clazz.getSimpleName() + ", with plate <<" + s + ">> - not created! : " + e.getMessage());
            }
        }
    }

    @Override
    public String call() throws Exception {
        Collections.shuffle(vehicleList);
        for (V vehicle : vehicleList) {
            try {
                parking.inputVehicle(vehicle);
                logger.info(name + ": Input vehicle: " + vehicle);

                Thread.sleep(sleepLong);
            } catch (Exception e) {
                logger.info(name + ": Input vehicle exception: " + e.getMessage() + ". Try again after some time");

                Thread.sleep(3000);
                try {
                    parking.inputVehicle(vehicle);
                    logger.info(name + ": Input again vehicle: " + vehicle);

                    Thread.sleep(sleepLong);
                } catch (Exception ee) {
                    logger.info(name + ": Input again vehicle exception: " + ee.getMessage());
                }
            }
        }

        Collections.shuffle(vehicleList);
        for (V vehicle : vehicleList) {
            try {
                parking.outputVehicle(vehicle);
                logger.info(name + ": Output vehicle: " + vehicle);

                Thread.sleep(sleepLong);
            } catch (Exception e) {
                logger.info(name + ": Output vehicle exception: " + e.getMessage());
            }
        }

        return parking.getParkingPlaces();
    }

}
