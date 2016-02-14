package com.javarush.test.level10.lesson11.home05;
class Main {
    public static void main(String[] args) {
        Integer i = new Integer("10");
        if (i.toString() == i.toString()) {
            System.out.println("Equal");
        } else {
            System.out.println("Unequal");
        }
    }
}