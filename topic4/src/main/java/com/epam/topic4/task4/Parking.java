package com.epam.topic4.task4;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Timofey_Ryuzhov on 4/4/2016.
 */
/*Приложение - парковка. Имеется стоянка, в ней N свободных мест в один ряд. Например, номера мест: A1, A2, A3, A4, A5, A6
* Машина заезжает, встает на место A1, следующая на место A2, и т.д.
* Тут машина выезжает с места A1, и следующая, которая заедет, встает уже на крайнее свободное левое, т.е. на A1
* Запрограммировать процесс с использованием наиболее подходящей коллекции в private поле. Необходимые функции обозначены.
* Реализовать собственные классы исключений:
* - когда выезжает машина, которой нет на стоянке, выкидывать checked exception
* - когда заезжает машина, которая уже есть на стоянке, выкидывать checked exception
* - когда заезжает машина, но закончились места на стоянке, выкидывать unchecked exception*
*
* В Main обрабатываем исключения
* */
public class Parking {
    private Queue<String> freePlace;
    private HashMap<String, String> car;
    private HashMap<String, String> place;

    public String getCarOnPlace(String place) {
        return this.place.get(place);
    }

    public String getPlaceOnCar(String car) {
        return this.car.get(car);
    }

    public class CarNotFound extends Exception {
        String carName;

        public CarNotFound(String carName) {
            this.carName = carName;
        }

        public String GetMyExceptionMsg() {
            return "WARNING!!! Car with registration number <<" + carName + ">> - Not Found";
        }
    }

    public class CarAlreadyParked extends Exception {
        String carName;
        String placeName;

        public CarAlreadyParked(String carName, String placeName) {
            this.carName = carName;
            this.placeName = placeName;
        }

        public String GetMyExceptionMsg() {
            return "WARNING!!! Car with registration number <<" + carName + ">> now parked on place <<" + placeName + ">>";
        }

    }

    public class NotFreePlaceException extends Error {
        public String GetMyErrorMsg() {
            return "ERROR!!! Not free place!";
        }
    }

    public Parking(Integer size) {
        freePlace = new PriorityQueue<String>();
        car = new HashMap<String, String>();
        place = new HashMap<String, String>();

        for (int i = 0; i < size; i++) {
            freePlace.add("A" + (i + 1));
            place.put("A" + (i + 1), null);
        }
    }

    public void inputCar(String carPlate) throws Exception {
        if (freePlace.size() == 0) throw new NotFreePlaceException();

        if (car.get(carPlate) != null) throw new CarAlreadyParked(carPlate, car.get(carPlate));

        String placeForNewCar = freePlace.remove();
        car.put(carPlate, placeForNewCar);
        place.put(placeForNewCar, carPlate);
    }

    public void outputCar(String carPlate) throws Exception {
        String outputCarPlace = car.get(carPlate);

        if (outputCarPlace == null) throw new CarNotFound(carPlate);

        car.remove(carPlate);
        place.put(outputCarPlace, null);
        freePlace.add(outputCarPlace);
    }

    public String getParkingPlaces() {
        String parkingStatus = "Parking status:";

        for (HashMap.Entry<String, String> entry : place.entrySet())
            parkingStatus += "\n" + entry.getKey() + " - " + (entry.getValue() == null ? "is Empty" : "car with number <<" + entry.getValue() + ">>");

        return parkingStatus;

    }
}
