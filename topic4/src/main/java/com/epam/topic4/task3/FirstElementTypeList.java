package com.epam.topic4.task3;

import java.util.ArrayList;

/**
 * Created by Timofey_Ryuzhov on 4/4/2016.
 */
/*Реализовать класс - контейнер списка, который первый элемент добавляет во внутреннюю коллекцию без проблем,
* но второй и последующий элементы должны совпадать по типу с первым, если типы не совпадают, то кидать исключение

* */
public class FirstElementTypeList {

    private ArrayList<Object> arrayList = null;

    public ArrayList<Object> getArrayList() {
        return arrayList;
    }

    public void add(Object o) throws Exception {
        if (arrayList == null)
            arrayList = new ArrayList<Object>();
        else if (arrayList.get(0).getClass() != o.getClass())
            throw new Exception("Новый элемент с типом " + o.getClass().getSimpleName() + " не соответствует изначальному типу данных " + arrayList.get(0).getClass().getSimpleName());

        arrayList.add(o);
    }
}
