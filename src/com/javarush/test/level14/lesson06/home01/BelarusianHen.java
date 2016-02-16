package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 130;
    }
    public String getDescription()
    {
        return super.getDescription()+" Моя страна - " + Country.BELARUS +". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
