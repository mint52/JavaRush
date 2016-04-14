package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0)
            return "";
        else {
            return "Your order: " + dishes.toString() + " of " + tablet;
        }
    }

    public int getTotalCookingTime() {
        int time = 0;
        for (Dish d : dishes) {
            time += d.getDuration();
        }
        return time;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();

    }

    protected void initDishes() throws IOException
    {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }


}
