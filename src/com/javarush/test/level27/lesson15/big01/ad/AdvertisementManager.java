package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager
{

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    private <Advetisement> List<List<Advetisement>> powerLists(List<Advetisement> originalSet)
    {
        List<List<Advetisement>> lists = new ArrayList<List<Advetisement>>();
        if (originalSet.isEmpty())
        {
            lists.add(new ArrayList<Advetisement>());
            return lists;
        }
        List<Advetisement> list = new ArrayList<Advetisement>(originalSet);
        Advetisement head = list.get(0);
        List<Advetisement> rest = new ArrayList<Advetisement>(list.subList(1, list.size()));
        for (List<Advetisement> set : powerLists(rest))
        {
            List<Advetisement> newSet = new ArrayList<Advetisement>();
            newSet.add(head);
            newSet.addAll(set);
            lists.add(newSet);
            lists.add(set);
        }
        return lists;
    }

    private List<Advertisement> chooseOptimalList(List<List<Advertisement>> list)
    {
        Iterator iterator = list.iterator();

        while (iterator.hasNext())
        {
            List<Advertisement> checkList = (List<Advertisement>) iterator.next();
            int fullDuration = 0;
            boolean removed = false;
            for (Advertisement advertisement : checkList)
            {
                fullDuration += advertisement.getDuration();
                if (advertisement.getHits() == 0)
                {
                    removed = true;
                    iterator.remove();
                    break;
                }
            }

            if (!removed)
                if (fullDuration > timeSeconds)
                  iterator.remove();

        }

        Collections.sort(list, new Comparator<List<Advertisement>>()
        {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2)
            {
                int price1 = 0;
                int price2 = 0;
                for (Advertisement ad : o1)
                    price1 += ad.getAmountPerOneDisplaying();

                for (Advertisement ad : o2)
                    price2 += ad.getAmountPerOneDisplaying();

                if (Integer.compare(price1, price2) == 0)
                {
                    int duration1 = 0;
                    int duration2 = 0;

                    for (Advertisement ad : o1)
                        duration1 += ad.getDuration();

                    for (Advertisement ad : o2)
                        duration2 += ad.getDuration();

                    if (Integer.compare(duration1, duration2) == 0)
                    {
                        return o1.size() - o2.size();
                    } else return duration2 - duration1;
                } else return price2 - price1;
            }
        });
        return list.get(0);
    }


    public void processVideos() throws NoVideoAvailableException
    {


        List<Advertisement> advertisements = new ArrayList<>(chooseOptimalList(powerLists(storage.list())));
        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();

        List<Advertisement> result = new ArrayList<>();
        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying()) == 0)
                {
                    long o1Price = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                    long o2Price = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                    return Long.compare(o1Price, o2Price);
                } else return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
            }
        });




        for (Advertisement advertisement : advertisements)
        {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
            advertisement.revalidate();
        }

        long sumAmount = 0;
        int sumDuration = 0;
        for (Advertisement a : advertisements)
        {
            sumAmount += a.getAmountPerOneDisplaying();
            sumDuration += a.getDuration();
        }

        VideoSelectedEventDataRow videoSelectedEventDataRow = new VideoSelectedEventDataRow(advertisements, sumAmount, sumDuration);
        StatisticEventManager.getInstance().register(videoSelectedEventDataRow);

    }


}
