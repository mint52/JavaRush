package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args)  {
       try {
           Solution solution1 = new Solution("d:/a.txt");
           solution1.writeObject("test");

           FileOutputStream fos = new FileOutputStream("d:/1.txt");
           ObjectOutputStream out = new ObjectOutputStream(fos);
           out.writeObject(solution1);
           out.close();


           FileInputStream fis = new FileInputStream("d:/1.txt");
           ObjectInputStream in = new ObjectInputStream(fis);
           Solution solution2 = (Solution) in.readObject();
           in.close();
           solution2.writeObject("ololo");
       }catch (Exception e)
       {
           System.out.println(e);
       }
    }

    transient private FileOutputStream stream;
    private String filename;
    public Solution(){}
    public Solution(String fileName) throws FileNotFoundException {
        this.filename = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(filename);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(filename, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
