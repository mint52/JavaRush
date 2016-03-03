package com.javarush.test.level22.lesson13.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0].toString()));
        FileWriter fileWriter = new FileWriter(args[1].toString());

        while (fileReader.ready())
        {
            String data = fileReader.readLine();
            byte[] buffer = data.getBytes("Windows-1251");
            String s = new String(buffer,"UTF-8");

            fileWriter.write(s);

        }
        fileReader.close();
        fileWriter.close();
    }
}
