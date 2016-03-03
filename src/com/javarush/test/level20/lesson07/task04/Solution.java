package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        Object object = null;
        try
        {
            fileInputStream = new FileInputStream("D:/a.txt");
            fileOutputStream = new FileOutputStream("D:/a.txt");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Не верное имя файла");
        }

        try
        {
            outputStream = new ObjectOutputStream(fileOutputStream);
            inputStream = new ObjectInputStream(fileInputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Solution savedObject = new Solution(30);
        Solution loadedObject = new Solution(20);
        System.out.println("loadedObject = " + loadedObject);

        try
        {
            outputStream.writeObject(savedObject);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("объект не записан");
        }

        try
        {
            loadedObject = (Solution) inputStream.readObject();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("объект не загружен");
        }


        fileInputStream.close();
        fileOutputStream.close();
        outputStream.close();
        inputStream.close();

        System.out.println(new Solution(4));
        System.out.println(savedObject);
        System.out.println(loadedObject);


    }

    transient private  final String pattern = "dd MMMM yyyy, EEEE";
    transient private  Date currentDate;
    transient private  int temperature;
     String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
