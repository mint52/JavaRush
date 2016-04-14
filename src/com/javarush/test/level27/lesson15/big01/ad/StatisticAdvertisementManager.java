package com.javarush.test.level27.lesson15.big01.ad;


import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        if (ourInstance == null) ourInstance = new StatisticAdvertisementManager();
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public TreeMap<String, Integer> getVideolist(int i){
        TreeMap<String, Integer> activeVideo = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        TreeMap<String, Integer> archivedVideo = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement ad : advertisementStorage.list()){
            if (ad.getHits() > 0)
                activeVideo.put(ad.getName(),ad.getHits());
            else archivedVideo.put(ad.getName(),ad.getHits());;
        }
        if (i == 0)
            return archivedVideo;
        else return activeVideo;

    }
}
