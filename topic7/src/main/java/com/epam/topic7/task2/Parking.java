package com.epam.topic7.task2;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Timofey_Ryuzhov on 5/8/2016.
 */

/*REQUIRED
* Приложение - парковка, аналогично парковке из topic4.  Имеется стоянка, в ней N свободных мест в один ряд.
* Место представляет собой класс Place.
* Теперь парковка может принимать автомобили(размер 1 - занимает одно место), грузовики (2 места), автобусы(3 места)
* Логика вся та же + соответственно грузовик и автобус могут парковаться только на 2 или 3 места, находящихся рядом
*
* В Main обрабатываем исключения
* */
public class Parking<T extends Place, U extends Vehicle> implements Serializable {

    private Map<Integer, T> freePlaces;
    private Map<T, U> places;
    private Map<String, U> vehicleNames;
    private Map<U, List<T>> vehiclePlaces;

    public U getVehicleOnPlace(T place) {
        return places.get(place);
    }

    public T getPlaceOnId(Integer placeId) {
        for (HashMap.Entry<T,U> e : places.entrySet())
            if (e.getKey().getId().equals(placeId)) return e.getKey();

        return null;
    }

    public Parking(List<T> placeList) {
        freePlaces = new TreeMap<Integer, T>();
        places = new LinkedHashMap<T, U>();
        vehicleNames = new HashMap<String, U>();
        vehiclePlaces = new HashMap<U, List<T>>();

        for (T t : placeList) {
            places.put(t, null);
            freePlaces.put(t.getId(), t);
        }
    }

    public void inputVehicle(U vehicle) throws Exception {
        if (freePlaces.size() == 0) throw new Exception("Exception (inputVehicle): Not free places");
        if (vehiclePlaces.get(vehicle) != null) throw new Exception("Exception (inputVehicle): Vehicle already parked");

        if (vehicleNames.get(vehicle.getName()) != null)
            if (vehiclePlaces.get(vehicleNames.get(vehicle.getName())) != null)
                throw new Exception("Exception (inputVehicle): Vehicle with name <<" + vehicle.getName() + ">>, already parked");


        Integer vehicleSize = vehicle.getSize();
        Integer findPlace = 0;
        Integer lastFindPlaceId = -1;

        List<T> placeList = new LinkedList<T>();

        for (HashMap.Entry<Integer, T> e : freePlaces.entrySet()) {
            if ((e.getKey() - lastFindPlaceId) > 1) {
                placeList.clear();
                findPlace = 1;
                placeList.add(e.getValue());
            } else {
                findPlace++;
                placeList.add(e.getValue());
            }

            if (findPlace.equals(vehicleSize)) break;

            lastFindPlaceId = e.getKey();
        }

        if (findPlace.equals(vehicleSize)) {
            for (T t : placeList) places.put(freePlaces.remove(t.getId()), vehicle);

            vehiclePlaces.put(vehicle, placeList);
            vehicleNames.put(vehicle.getName(), vehicle);
        } else throw new Exception("Exception (inputVehicle): Not free places");
    }

    public void outputVehicle(U vehicle) throws Exception {
        List<T> placeList = vehiclePlaces.get(vehicle);

        if (placeList == null) throw new Exception("Exception (outputVehicle): Vehicle not found");

        vehiclePlaces.put(vehicle, null);

        for (T t : placeList) {
            places.put(t, null);
            freePlaces.put(t.getId(), t);
        }
    }

    public String getParkingPlaces() {
        String parkingStatus = "Parking places:";

        for (HashMap.Entry<T, U> e : places.entrySet())
            parkingStatus += "\n" + e.getKey().getName() + " - " + (e.getValue() == null ? "is Empty" : "Vehicle <<" + e.getValue() + ">>");

        return parkingStatus + "\n";
    }
}
