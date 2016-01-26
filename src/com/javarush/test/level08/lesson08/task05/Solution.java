package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String , String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for(Map.Entry<String, String> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());;
        }
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Фамилия1","Имя7");
        map.put("Фамилия2","Имя");
        map.put("Фамилия3","Имя2");
        map.put("Фамилия4","Имя3");
        map.put("Фамилия5","Имя4");
        map.put("Фамилия6","Имя");
        map.put("Фамилия7","Имя5");
        map.put("Фамилия8","Имя");
        map.put("Фамилия9","Имя6");
        map.put("Фамилия","Имя");


        //напишите тут ваш код
        return map;

    }



    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pairCopy : copy.entrySet())

        {
            int count = 0;
            for (Map.Entry<String, String> pairMap : map.entrySet())
            {
                if (pairMap.getValue().equals(pairCopy.getValue()))
                {
                    count++;
                }
            }
            if (count > 1)
            {
                removeItemFromMapByValue(map, pairCopy.getValue());
            }
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());


        }
    }
}
