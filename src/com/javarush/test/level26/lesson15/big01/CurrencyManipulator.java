package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<Integer, Integer>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int summ = 0;
        for (Map.Entry<Integer, Integer> map : denominations.entrySet()) {
            summ += map.getKey() * map.getValue();
        }
        return summ;

    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {

        Map<Integer, Integer> temp = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> original = new HashMap<>(denominations);
        ArrayList<Integer> list = new ArrayList<>(denominations.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            if (expectedAmount > 0) {
                int nominal = list.get(i);
                if (expectedAmount >= nominal) {
                    int count = expectedAmount / nominal;
                    if (denominations.get(nominal) > count) {
                        temp.put(nominal, count);
                        denominations.put(nominal, denominations.get(nominal) - count);
                        expectedAmount = expectedAmount - count * nominal;
                    } else {
                        temp.put(nominal, denominations.get(nominal));
                        expectedAmount = expectedAmount - denominations.get(nominal) * nominal;
                        denominations.remove(nominal);
                    }
                }
            } else break;
        }
        if (expectedAmount != 0) {
            denominations = original;
            throw new NotEnoughMoneyException();
        }


        return temp;
    }

}
