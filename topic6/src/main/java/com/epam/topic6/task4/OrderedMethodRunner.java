package com.epam.topic6.task4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
public class OrderedMethodRunner {

    private OrderedMethodRunner() {

    }

    public static void run(Class clazz) {
        try {
            Object obj = clazz.newInstance();

            Map<String, Method> methods = new TreeMap<String, Method>();

            for (Method m : clazz.getDeclaredMethods()) {

                Annotation annotation = m.getAnnotation(Invoke.class);
                Invoke methodProperties = (Invoke) annotation;

                int priorInt;

                if (m.isAnnotationPresent(First.class)) priorInt = 0;
                else if (m.isAnnotationPresent(Last.class)) priorInt = Integer.MAX_VALUE;
                else if (m.isAnnotationPresent(Invoke.class)) priorInt = methodProperties.priority();
                else priorInt = Integer.MAX_VALUE - 1;

                methods.put(String.format("%10s", priorInt).replace(' ', '0') + "_" + m.getName(), m);
            }

            for (Map.Entry<String, Method> m : methods.entrySet()) {
                m.getValue().invoke(obj);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
