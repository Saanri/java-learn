package com.epam.topic7.task3;

/**
 * Created by Timofey_Ryuzhov on 5/3/2016.
 */
public interface Containable {
    int getSize();

    String getName();

    /**
     * Описывает процесс распаковки объектов(например, матрешки)
     *
     * @return строку описания
     */
    String unpack(String title);

    <T extends Containable> void addInner(T innerObject);

    /**
     * Цена объекта + всех вложенных объектов
     *
     * @return цену
     */
    double getCost();
}
