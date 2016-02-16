package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 100;
    }
    public String getDescription()
    {
        return super.getDescription()+" Моя страна - " + Country.MOLDOVA +". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
