package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        InputStream inStream = new FileInputStream(s);

        while (inStream.available() > 0)
        {
            //int data = inStream.read(); //читаем один int из потока для чтения
            System.out.print((char)inStream.read()); //записываем прочитанный int в другой поток.
        }

        inStream.close();
        //закрываем потоки//add your code here
    }
}
