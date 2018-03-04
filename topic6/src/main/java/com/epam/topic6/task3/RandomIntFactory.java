package com.epam.topic6.task3;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
public class RandomIntFactory {

    private RandomIntFactory() {

    }

    public static RandomField getInstance() {
        RandomField randomField = new RandomField();

        Class aClass = randomField.getClass();

        for (Field f : aClass.getDeclaredFields())
            if (f.isAnnotationPresent(RandomInt.class) && f.getType().getSimpleName().equals("int")) {
                RandomInt randomInt = f.getAnnotation(RandomInt.class);

                Random random = new Random();

                f.setAccessible(true);

                try {
                    f.setInt(randomField, random.nextInt(randomInt.max() - randomInt.min() + 1) + randomInt.min());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                f.setAccessible(false);
            }

        return randomField;
    }
}
