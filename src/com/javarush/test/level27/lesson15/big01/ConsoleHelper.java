package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {

        String s = reader.readLine();

        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {

        List<Dish> result = new ArrayList<>();
        String dish;

        writeMessage("Выберите блюдо: " + Dish.allDishesToString());

            while (true) {
               dish = reader.readLine();
               if (dish.equals("exit"))break;
                try {
                    result.add(Dish.valueOf(dish));

                } catch (IllegalArgumentException e) {
                    ConsoleHelper.writeMessage(String.format("%s is not detected", dish));

                }
            }
        return result;
    }
}
