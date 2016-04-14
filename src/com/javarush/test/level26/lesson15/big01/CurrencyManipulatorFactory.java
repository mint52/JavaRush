package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CurrencyManipulatorFactory {

    public static Map<String, CurrencyManipulator> manipulators = new HashMap<String, CurrencyManipulator>();

    private CurrencyManipulatorFactory() {
    }



    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (manipulators.get(currencyCode) == null) {
            manipulators.put(currencyCode, new CurrencyManipulator(currencyCode));
        }
        return manipulators.get(currencyCode);

    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return manipulators.values();
    }
}