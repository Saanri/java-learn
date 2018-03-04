package com.epam.topic7.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Timofey_Ryuzhov on 5/3/2016.
 */
//REQUIRED
//Реализйте методы по описанию, добавив нужные сигнатуры Generics
public class Utils {
    // Метод копирования одного списка в другой в обратном порядке (Tip: use super T, extends T)
    public static <T> void toReverseList(List<? extends T> srcList, List<? super T> dst) {
        dst.clear();
        dst.addAll(srcList);
        Collections.reverse(dst);
    }

    // Параметризованный метод должен возвращать новый список, состоящий только из чисел, которые больше заданного
    public static <T extends Number & Comparable<T>> List<Number> copyGreaterNumbers(List<T> src, T num) {
        List<Number> list = new ArrayList<Number>();

        for (T t : src)
            if (t.compareTo(num) > 0)
                list.add(t);

        return list;
    }

    // Параметризованный метод, который проставляет значения в коллекцию "мапов" и возвращает список предыдущих значений
    public static <T, U> List<U> setValues(List<Map<T, U>> mapList, T key, U value) {
        List<U> list = new ArrayList<U>();

        for (Map<T, U> map : mapList) list.add(map.put(key, value));

        return list;
    }

    // Параметризованный метод, который возвращает новый объект указанного в параметрах класса
    public static <T> T createObject(Class<T> clazz) throws Exception {
        return clazz.newInstance();
    }
}
