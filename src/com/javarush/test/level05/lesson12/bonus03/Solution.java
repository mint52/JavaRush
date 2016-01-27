package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE ;
        int A = Integer.parseInt(reader.readLine());
        if (A > 0)
        {
            for (int i = 0;i<A;i++)
            {
                int a = Integer.parseInt(reader.readLine());
                if (maximum<a)
                    maximum = a;
            }
        }
        //напишите тут ваш код




        System.out.println(maximum);
    }
}
