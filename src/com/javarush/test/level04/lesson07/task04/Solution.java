package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count1 = 0;
        int count2 =0;
        for (int i = 0; i <3;i++)
        {
            int a = Integer.parseInt(reader.readLine());
            if (a>=0)
                count1++;
            else count2++;
        }
        System.out.println("количество отрицательных чисел: "+count2);
        System.out.println("количество положительных чисел: "+count1);
     /*   int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int p = 0;
        int o = 0;
        if (a>=0)
            p++;
        else
            o++;
        if (b>=0)
            p++;
        else
            o++;
        if (c>=0)
            p++;
        else
            o++;
        System.out.println("количество отрицательных чисел: "+o);
        System.out.println("количество положительных чисел: "+p);
        //напишите тут ваш код */

    }
}
