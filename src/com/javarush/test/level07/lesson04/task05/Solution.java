package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[20];
        for (int i = 0;i < num.length;i++)
        {
            num[i] = Integer.parseInt(reader.readLine());
        }
        int[] num2 = new int[10];
        for (int i = 0;i < num2.length;i++ )
        {
            num2[i] = num[i];

        }

        int[] num3 = new int[10];
        int b = 10;
        for (int i = 0;i < num3.length;i++,b++)
        {
            num3[i] = num[b];
            System.out.println(num3[i]);

        }





        //напишите тут ваш код

    }
}
