package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {

    public void printAdvertisementProfit(){
        Map<Date, Double> map = StatisticEventManager.getInstance().getAllDateAmount();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double total = 0;
        for (Map.Entry<Date, Double> pair : map.entrySet())
        {
            total+= pair.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(pair.getKey()), pair.getValue()));

        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f",total));
    }

    public void printCookWorkloading(){
        Map<Date, TreeMap<String, Integer>> map = StatisticEventManager.getInstance().getCookInfo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (Map.Entry<Date, TreeMap<String, Integer>> pair : map.entrySet()){
         //  ConsoleHelper.writeMessage("");
            ConsoleHelper.writeMessage(dateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> pair2 : pair.getValue().entrySet()){
                ConsoleHelper.writeMessage(pair2.getKey()+" - "+(int) Math.ceil(pair2.getValue())+" min");
            }
            ConsoleHelper.writeMessage("");
        }

    }

    public void printActiveVideoSet(){
        TreeMap<String, Integer> activeVideo = StatisticAdvertisementManager.getInstance().getVideolist(1);

        for (Map.Entry<String, Integer> activ : activeVideo.entrySet() ){
            ConsoleHelper.writeMessage(activ.getKey()+" - "+activ.getValue());
        }
    }

    public void printArchivedVideoSet(){
        TreeMap<String, Integer> archivedVideo = StatisticAdvertisementManager.getInstance().getVideolist(0);

        for (Map.Entry<String, Integer> activ : archivedVideo.entrySet() ){
            ConsoleHelper.writeMessage(activ.getKey());
        }
    }
}
