package com.github.mkouba;

import java.lang.reflect.InvocationTargetException;

@TestAnnotation
public class Main {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        TestAnnotation annotation = Main.class.getAnnotation(TestAnnotation.class);
        System.out.println(annotation.getClass().getDeclaredMethod("maxRetries").invoke(annotation));
    }

}
