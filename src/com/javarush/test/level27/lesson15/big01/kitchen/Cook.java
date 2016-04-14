package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer{


    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object order) {


        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %smin",order,((Order)order).getTotalCookingTime()));

        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(o.toString(),this.name,((Order)order).getTotalCookingTime()*60,((Order) order).getDishes());
        StatisticEventManager.getInstance().register(cookedOrderEventDataRow);

        setChanged();
        notifyObservers(order);


    }
}
