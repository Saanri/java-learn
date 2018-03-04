package com.epam.topic6.task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Iurii Talalaev on 24.04.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldProperties {

    String type() default "FIELD";

    String name();

    String scope();

    String description();
}
