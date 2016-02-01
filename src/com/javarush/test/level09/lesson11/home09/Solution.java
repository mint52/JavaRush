package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<String> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String, Cat>();

        for (int i = 0;i<10;i++)
        {
            map.put("vaska"+i,new Cat("vaska"+i));
        }


        return map;
        //напишите тут ваш код
    }

    public static Set<String> convertMapToSet(Map<String, Cat> map)
    {
        Set<String> set = new HashSet<String>();
        for (Map.Entry<String, Cat> pair : map.entrySet())
        {
            set.add(pair.getKey());
        }
        return set;
        //напишите тут ваш код
    }

    public static void printCatSet(Set<String> set)
    {
        for (String cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
