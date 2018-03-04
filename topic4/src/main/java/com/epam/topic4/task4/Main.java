package com.epam.topic4.task4;

import com.epam.topic4.LogFactory;
import org.apache.log4j.Logger;

/**
 * Created by Timofey_Ryuzhov on 4/4/2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        LogFactory logFactory = new LogFactory("com.epam.topic4.task4.Parking");
        Logger logger = logFactory.getLogger();

        Parking parking = new Parking(5);
        parking.inputCar("К123ЕУ");
        parking.inputCar("Ц567ЕН");
        parking.inputCar("У468РИ");
        logger.info(parking.getParkingPlaces());
        parking.outputCar("К123ЕУ");
        logger.info(parking.getParkingPlaces());
        parking.inputCar("W12388ЕУ");
        logger.info(parking.getParkingPlaces());

        try {
            parking.outputCar("Y394DD"); // custom checked error No such car. Use logger in exception handling
        } catch (Parking.CarNotFound e) {
            logger.info(e.GetMyExceptionMsg());
        }

        try {
            parking.inputCar("W12388ЕУ"); // custom checked error Already parked. Use logger in exception handling
        } catch (Parking.CarAlreadyParked e) {
            logger.info(e.GetMyExceptionMsg());
        }

        parking.inputCar("Е777КА");
        parking.inputCar("В163УК");

        try {
            parking.inputCar("H1244WQ"); // custom unchecked error No more free places. Use logger in exception handling
        } catch (Parking.NotFreePlaceException e) {
            logger.info(e.GetMyErrorMsg());
        }

        logger.info(parking.getParkingPlaces());
    }
}
