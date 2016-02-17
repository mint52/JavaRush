package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double d;
    public Money(double amount)
    {
        this.d = amount;
    }

    public double getAmount()
    {
       return d;
    }

    public abstract String getCurrencyName();
}

