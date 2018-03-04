package com.epam.topic7.task2;

import com.epam.topic7.LogFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timofey_Ryuzhov on 5/8/2016.
 */
//Демонстрация работы парковки, или реализовать unit-тесты
public class Main {
    private static Logger logger = LogFactory.getLogger(Parking.class.getName());

    public static void main(String[] args) throws Exception {
        List<Place> placeList = new ArrayList<Place>();
        for (int i = 0; i < 5; i++) placeList.add(new Place(i, "A" + i));
        logger.info("Create 5 parking place");

        Parking<Place, Vehicle> parking = new Parking<Place, Vehicle>(placeList);

        Car car1 = new Car();
        car1.setName("H345GT");
        logger.info("input Car <<H345GT>>");
        parking.inputVehicle(car1);
        logger.info(parking.getParkingPlaces());

        Truck truck1 = new Truck();
        truck1.setName("F002NN");
        logger.info("input Truck <<F002NN>>");
        parking.inputVehicle(truck1);
        logger.info(parking.getParkingPlaces());

        logger.info("output Truck <<F002NN>>");
        parking.outputVehicle(truck1);
        logger.info(parking.getParkingPlaces());

        logger.info("input Truck <<F002NN>>");
        parking.inputVehicle(truck1);
        logger.info(parking.getParkingPlaces());

        logger.info("output Car <<H345GT>>");
        parking.outputVehicle(car1);
        logger.info(parking.getParkingPlaces());

        Bus bus1 = new Bus();
        bus1.setName("B777XX");
        logger.info("input Bus <<B777XX>>");
        try {
            parking.inputVehicle(bus1);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        logger.info(parking.getParkingPlaces());

        logger.info("input Car <<H345GT>>");
        parking.inputVehicle(car1);
        logger.info(parking.getParkingPlaces());

        logger.info("output Truck <<F002NN>>");
        parking.outputVehicle(truck1);
        logger.info(parking.getParkingPlaces());

        logger.info("input Bus <<B777XX>>");
        parking.inputVehicle(bus1);
        logger.info(parking.getParkingPlaces());

        Car car2 = new Car();
        car2.setName("H345GT");
        logger.info("input new Car with already name <<H345GT>>");
        try {
            parking.inputVehicle(car2);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        logger.info(parking.getParkingPlaces());

        Car car3 = new Car();
        car3.setName("C409HH");
        logger.info("output Car <<C409HH>>");
        try {
            parking.outputVehicle(car3);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}
