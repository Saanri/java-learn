package com.epam.topic8.task2;

import com.epam.topic7.LogFactory;
import com.epam.topic7.task2.*;
import com.epam.topic7.task3.Containable;
import com.epam.topic7.task3.Matryoshka;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timofey_Ryuzhov on 5/23/2016.
 */

/* REQUIRED
Приложение ObjectSerializator
* Реализовать методы save  и restore, которые сохраняют и соответственно восстанавливают объекты из файла.
* (Optional) При сохранении информации данные шифровать при помощи Base64
* Продемонстрировать работу класса на объектах Parking и Matryoshka из topic 7(эти классы могут быть импортированы из соседнего модуля,
для этого может потребоваться добавить topic7 в Dependencies в Project Structure)
* В объекте матрешки поле color сохраняться НЕ ДОЛЖНО (required).
* В параметре filename может быть как имя файла, так и путь содержащий data/filename.txt (создавать в случае необходимости папку data) .
Или же полный путь ( если путь некорректный - выкидывать ошибку)*/

public class Main {

    private static final String FILE_PATH1 = "data/matryoushka.dat";
    private static final String FILE_PATH2 = "C:/data/matryoushka.dat";
    private static final String FILE_PATH3 = "matryoushka.dat";
    private static final String FILE_PATH4 = "parking.dat";

    private static Logger logger = LogFactory.getLogger(ObjectSerializator.class.getName());

    public static void main(String[] args) throws Exception {
        logger.info("---- Input/Output matryoshka ----");

        Containable matryoshka = new Matryoshka(8, 100);

        int i = 0;
        String[] filePathList = new String[] {FILE_PATH1,FILE_PATH2,FILE_PATH3};
        for (String s : filePathList) {
            ObjectSerializator.save(matryoshka, s);
            Matryoshka restorMatryoshka = ObjectSerializator.restore(s);
            logger.info(restorMatryoshka.unpack("Unpack matryoshka_" + ++i +" : \n"));
        }

        logger.info("---- Input/Output parking ----");

        List<Place> placeList = new ArrayList<Place>();
        for (i = 0; i < 6; i++) placeList.add(new Place(i, "A" + i));
        logger.info("Create 6 parking place");

        Parking<Place, Vehicle> parking = new Parking<Place, Vehicle>(placeList);

        Car car1 = new Car();
        car1.setName("H345GT");
        logger.info("input Car <<H345GT>>");
        parking.inputVehicle(car1);

        Truck truck1 = new Truck();
        truck1.setName("F002NN");
        logger.info("input Truck <<F002NN>>");
        parking.inputVehicle(truck1);

        Bus bus1 = new Bus();
        bus1.setName("B777XX");
        logger.info("input Bus <<B777XX>>");
        parking.inputVehicle(bus1);

        ObjectSerializator.save(parking, FILE_PATH4);
        Parking<Place, Vehicle> parking_restored = ObjectSerializator.restore(FILE_PATH4);
        logger.info(parking_restored.getParkingPlaces());
    }

}
