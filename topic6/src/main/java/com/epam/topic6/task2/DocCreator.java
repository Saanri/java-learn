package com.epam.topic6.task2;

import com.epam.topic6.LogFactory;
import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Timofey_Ryuzhov on 4/19/2016.
 */
public class DocCreator {
    private static Logger logger = LogFactory.getLogger(DocCreator.class.getName());

    private static void logClassProperties(Class clazz) {
        if (clazz.isAnnotationPresent(ClassProperties.class)) {
            Annotation annotation = clazz.getAnnotation(ClassProperties.class);
            ClassProperties classProperties = (ClassProperties) annotation;

            logger.info("   clazz has following properties:");
            logger.info("       - type = " + classProperties.type());
            logger.info("       - name = " + classProperties.name());
            logger.info("       - author = " + classProperties.author());
            logger.info("       - date = " + classProperties.date());
            logger.info("       - description = " + classProperties.description());
            logger.info("       - version = " + classProperties.version());
        }
    }

    private static void logFieldProperties(Class clazz) {
        if (clazz.getDeclaredFields().length > 0)
            logger.info("   Fields (" + clazz.getDeclaredFields().length + "):");

        int i = 0;
        for (Field f : clazz.getDeclaredFields()) {
            i++;
            if (f.isAnnotationPresent(FieldProperties.class)) {
                logger.info("       (" + i + ") Field <<" + f.getName() + ">> with following properties:");
                Annotation annotation = f.getAnnotation(FieldProperties.class);
                FieldProperties fieldProperties = (FieldProperties) annotation;

                logger.info("           - type = " + fieldProperties.type());
                logger.info("           - name = " + fieldProperties.name());
                logger.info("           - scope = " + fieldProperties.scope());
                logger.info("           - description = " + fieldProperties.description());
            }
        }
    }

    private static void logMethodProperties(Class clazz) {
        if (clazz.getDeclaredMethods().length > 0)
            logger.info("   Methods (" + clazz.getDeclaredMethods().length + "):");

        int i = 0;
        for (Method m : clazz.getDeclaredMethods()) {
            i++;
            if (m.isAnnotationPresent(MethodProperties.class)) {
                logger.info("       (" + i + ") Method <<" + m.getName() + ">> with following properties:");
                Annotation annotation = m.getAnnotation(MethodProperties.class);
                MethodProperties methodProperties = (MethodProperties) annotation;

                logger.info("           - type = " + methodProperties.type());
                logger.info("           - name = " + methodProperties.name());
                logger.info("           - scope = " + methodProperties.scope());

                String params;
                params = "";
                for (String s : methodProperties.params())
                    params += (params.isEmpty() ? s : "; " + s);

                logger.info("           - params: " + (params.isEmpty() ? "nothing" : params));
                logger.info("           - description = " + methodProperties.description());
            }
        }
    }

    public static void createDoc(Class clazz) {
        logger.info("I process annotations in the clazz and do logger.info with it");

        logClassProperties(clazz);
        logFieldProperties(clazz);
        logMethodProperties(clazz);
    }
}
