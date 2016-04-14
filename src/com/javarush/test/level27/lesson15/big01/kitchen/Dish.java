package com.javarush.test.level27.lesson15.big01.kitchen;


import java.util.Arrays;

public enum Dish {

    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {

        this.duration = duration;
    }

    public int getDuration() {

        return duration;
    }

    public static String allDishesToString() {
        String resultString = Arrays.toString(Dish.values());
        return resultString.substring(resultString.indexOf("[") + 1, resultString.lastIndexOf("]"));
    }

}
