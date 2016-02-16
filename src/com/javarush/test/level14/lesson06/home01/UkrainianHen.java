package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 0;
    }

    public String getDescription()
    {
        return super.getDescription()+" Моя страна - " + Country.UKRAINE +". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
