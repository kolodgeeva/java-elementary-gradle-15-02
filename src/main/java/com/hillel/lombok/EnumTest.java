package com.hillel.lombok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EnumTest {

    public static void main(String[] args) throws IOException {

        System.out.println(Apple.JONATHAN);

        System.out.println("---------------------");

        Arrays.stream(Apple.values()).forEach(System.out::println);

        System.out.println("---------------------");

        System.out.println("Pls input sort of apple you want:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Apple apple;
        try {
            apple = Apple.valueOf(reader.readLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            apple = Apple.UNKNOWN;
        }

        System.out.println("---------------------");

        variant1(apple);

        System.out.println("---------------------");

        variant2(apple);

    }

    private static void variant2(Apple apple) {

        if (apple == Apple.UNKNOWN) {
            System.out.println("Sorry, we have not " + Apple.UNKNOWN);
            return;
        }

        System.out.println("User would like to order " + apple);

    }

    private static void variant1(Apple apple) {
        switch (apple) {
            case RED:
                System.out.println("User would like to order " + Apple.RED);
                break;
            case GOLDEN:
                System.out.println("User would like to order " + Apple.GOLDEN);
                break;
            case WINESAP:
                System.out.println("User would like to order " + Apple.WINESAP);
                break;
            case JONATHAN:
                System.out.println("User would like to order " + Apple.JONATHAN);
                break;
            case UNKNOWN:
                System.out.println("Sorry, we have not " + Apple.UNKNOWN);
                break;
        }
    }

    public enum Apple {
        JONATHAN,
        GOLDEN,
        RED,
        WINESAP,
        UNKNOWN
    }

    public enum OrderStatus {
        NEW,
        IN_PROGRESS,
        DONE,
        ERROR
    }
}
