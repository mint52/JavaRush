package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("January","1");
        map.put("February","2");
        map.put("March","3");
        map.put("April","4");
        map.put("May","5");
        map.put("June","6");
        map.put("July","7");
        map.put("August","8");
        map.put("September","9");
        map.put("October","10");
        map.put("November","11");
        map.put("December","12");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String mes = reader.readLine();

        if (map.containsKey(mes))
            System.out.println(mes+" "+"is"+" "+map.get(mes)+" "+"month");

        //напишите тут ваш код
    }

}
