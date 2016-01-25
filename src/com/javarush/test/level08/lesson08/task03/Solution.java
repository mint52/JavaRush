package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
       HashMap<String, String> map = new HashMap<String, String>();

        map.put("Иванов1","Иван1");
        map.put("Иванов2","Иван2");
        map.put("Иванов3","Иван3");
        map.put("Иванов4","Иван4");
        map.put("Иванов5","Иван5");
        map.put("Иванов6","Иван4");
        map.put("Иванов7","Иван3");
        map.put("Иванов8","Иван2");
        map.put("Иванов1","Иван1");
        map.put("Иванов0","Иван3");

        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код

    }
}
