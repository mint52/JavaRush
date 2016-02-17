package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread st1 = new SpecialThread();
        list.add(new Thread(st1));
        SpecialThread st2 = new SpecialThread();
        list.add(new Thread(st2));
        SpecialThread st3 = new SpecialThread();
        list.add(new Thread(st3));
        SpecialThread st4 = new SpecialThread();
        list.add(new Thread(st4));
        SpecialThread st5 = new SpecialThread();
        list.add(new Thread(st5));

        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
