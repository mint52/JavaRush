package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        for (int i = 0; i < 5; i++)
        {
            String s = reader.readLine();
            a = s.length();
            list.add(s);

        }
        int max = 0;
        for (int i =0; i <list.size();i++)
        {
            if (max < list.get(i).length())
            {
                max = a;
            }
        }
        System.out.println(list.get(max));

        //напишите тут ваш код

    }
}
