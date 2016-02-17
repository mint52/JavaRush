package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(1.2,"s");
        labels.put(1.3,"d");
        labels.put(1.8,"o");
        labels.put(1.24,"q");
        labels.put(1.12,"n");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
