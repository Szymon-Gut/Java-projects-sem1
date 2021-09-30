package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // firstMethod();
        testStringClassicConcatenation();
        testThreadSafeStringConcatenation();
        testFastestThreadNotSafeStringConcatenation();
    }

    private static void firstMethod() {
        String myString = "napis";

//        if myString.equals();

        int counter;
        Integer integer = Integer.valueOf(11);
        Double doule;
        int parsedInteger = Integer.parseInt("1234");
        Float myFloat;

        Long myLong = 1l;
        System.out.println("Parsed int: " + parsedInteger);


        if (myLong == 26) {
            System.out.println("test");
        }

        integer.toString();
        System.out.println("Parsed int: " + integer);

        RepresentME representME = new RepresentME();
        System.out.println("Represent me: " + representME.toString());

        Math.pow(2, 2);
        Random myRandom = new Random();
        System.out.println("" + myRandom.nextInt(20));

        for (int i = 0; i < 5; i++) {
            System.out.println("Random values: " + (myRandom.nextInt(5) + 5));
        }

        System.out.println(" ");

        // NIE kleimy stringow (i prawda i nie)

        System.out.println("First" + "Second" + "Third");
        System.out.println("First".concat("Second"));

        // ##################################################
    }

    private static void testStringClassicConcatenation() {
        String result = "";

        long before = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            result += "Add something";
        }
        long time = System.currentTimeMillis() - before;
        System.out.println("Total time (classic): " + time / 1000.0); // lub 1000d


    }

    private static void testThreadSafeStringConcatenation() {
        String result = "";

        StringBuffer stringBuffer = new StringBuffer(result);
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            stringBuffer.append("Add something");
        }
        result = stringBuffer.toString();
        long time = System.currentTimeMillis() - before;

        System.out.println("Total time (stringbuffer): " + time / 1000.0); // lub 1000d
    }

    private static void testFastestThreadNotSafeStringConcatenation() {
        String result = "";

        StringBuilder stringBuilder = new StringBuilder(result);
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            stringBuilder.append("Add something");
        }
        result = stringBuilder.toString();
        long time = System.currentTimeMillis() - before;

        System.out.println("Total time (stringbuilder): " + time / 1000.0); // lub 1000d


    }
}
