package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i =0;
        try {
        while (true)
        {

            System.out.println(String.format("Some text for %d", ++i));
            Thread.sleep(500);
        }
            } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
            }
        }


    }


