package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
Подсказка:
Нужно написать тело обеих существующих функций min и исправить их возвращаемые значения.
*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
        int m2;
        if (min(a,b)<c)
            m2 = min(a,b);
        else
            m2 = c;
        if (m2<d);
        else m2 = d;

        //напишите тут ваш код
        return m2;
    }

    public static int min(int a, int b)
    {
        int m1;
        if (a<b)
            m1 = a;
        else
            m1 = b;
        return m1;
        //напишите тут ваш код

    }

    public static void main(String[] args) throws Exception
    {
        System.out.println( min(-20, -10) );
        System.out.println( min(-20, -10, -30, -40) );
        System.out.println( min(-20, -10, -30, 40) );
    }
}