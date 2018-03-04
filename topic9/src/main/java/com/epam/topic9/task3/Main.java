package com.epam.topic9.task3;

import com.epam.topic7.LogFactory;
import com.epam.topic7.task2.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Timofey_Ryuzhov on 6/8/2016.
 */
/* REQUIRED Парковка
 Доработать класс парковка для работы в многопоточном режиме
 Трансп. средства(TC)  могут заезжать на парковку через N ворот (возможна работа только N потоков одновременно)
 Поток параметризован, принимает  TC только определенного типа(e.g. Car, Truck, Bus) + принимает список гос. номеров(ArrayList<String>)
 Сначала поток в рандомном порядке запускает ТС на парковку, затем в рандомном порядке - выпускает через определенный
 timeout (1-2 сек)
 Поток должен возвращать результат - объект Парковка или его toString() представление после выполнения всех операций (input - output) и выводить в log
 */
public class Main {
    private static Logger logger = LogFactory.getLogger(Main.class.getName());
    public static final int parkingPaceCount = 50;
    public static final int parkingGateCount = 3;


    public static void main(String[] args) throws InterruptedException {
        List<Place> placeList = new ArrayList<Place>();
        for (int i = 0; i < parkingPaceCount; i++) placeList.add(new Place(i, "A" + i));
        logger.info("Create " + placeList.size() + " parking place");
        Thread.sleep(1000);

        Parking<Place, Vehicle> parking = new Parking<Place, Vehicle>(placeList, parkingGateCount);
        logger.info("Create parking with " + parking.getCountPalce() + " place, and " + parking.getCountGate() + " gates.");
        Thread.sleep(1000);

        ArrayList<String> carPlateList = new ArrayList<String>();
        Collections.addAll(carPlateList, "IHTIW", "MIAD6", "4XQ10", "HJDGB", "WNWCF", "JMD0Z", "3MQT4", "61K9Q", "Y04W7", "7DSP3", "GKZN9", "HOINM", "R8MBQ", "RG4JY", "UOXV5");
        logger.info("Create car plate list. Count plates: " + carPlateList.size());
        Thread.sleep(1000);

        ArrayList<String> trackPlateList = new ArrayList<String>();
        Collections.addAll(trackPlateList, "CFF5H", "RKC2S", "NRY3Q", "WKB1N", "8QOA8", "TJY7Q", "XTAGA", "HO6A7", "CNVHO");
        logger.info("Create track plate list. Count plates: " + trackPlateList.size());
        Thread.sleep(1000);

        ArrayList<String> busPlateList = new ArrayList<String>();
        Collections.addAll(busPlateList, "F3H0U", "93YH7", "7BOVT", "SF4H6", "Z03VS", "CJZ3U");
        logger.info("Create bus plate list. Count plates: " + busPlateList.size());
        Thread.sleep(1000);

        HashMap<Class, ArrayList<String>> groupVehicle = new HashMap<Class, ArrayList<String>>();
        groupVehicle.put(Car.class, carPlateList);
        groupVehicle.put(Truck.class, trackPlateList);
        groupVehicle.put(Bus.class, busPlateList);

        List<Future> futureList = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (HashMap.Entry<Class, ArrayList<String>> e : groupVehicle.entrySet()) {
            ParkingThread parkingThread = new ParkingThread(parking, e.getKey(), e.getValue());
            Thread.sleep(333);

            Future f = executorService.submit(parkingThread);
            futureList.add(f);

        }
        executorService.shutdown();

        logger.info("Executor service - shutdown. Result:");

        for (Future f : futureList)
            try {
                logger.info(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
    }

}
