package com.javarush.test.level04.lesson16.home02;

import java.io.BufferedReader;
import java.io.InputStreamReader;/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        a[0] = Integer.parseInt(reader.readLine());
        a[1] = Integer.parseInt(reader.readLine());
        a[2] = Integer.parseInt(reader.readLine());

        Arrays.sort(a);


        System.out.println(a[1]);


        //напишите тут ваш код
    }
}
