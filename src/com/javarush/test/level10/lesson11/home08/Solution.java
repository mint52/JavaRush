package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] mass = new ArrayList[10];
        ArrayList<String> list = new ArrayList<String>();
        for (int j = 0; j < 10 ; j++)
        {

            for (int i = 0; i < 5 ; i++)
            {
                list.add("ololo"+i);
            }
           mass[j] = list;
        }
        //напишите тут ваш код

        return mass;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}