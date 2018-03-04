package com.epam.topic6.task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Iurii Talalaev on 24.04.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassProperties {

    String type() default "CLASS";

    String name();

    String scope();

    String author();

    String date();

    String description();

    double version() default 1.0;
}
