package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg1 = new Zerg();
        zerg1.name = "zerg1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "zerg2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "zerg3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "zerg4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "zerg5";
        Zerg zerg6 = new Zerg();
        zerg6.name = "zerg6";
        Zerg zerg7 = new Zerg();
        zerg7.name = "zerg7";
        Zerg zerg8 = new Zerg();
        zerg8.name = "zerg8";
        Zerg zerg9 = new Zerg();
        zerg9.name = "zerg9";
        Zerg zerg0 = new Zerg();
        zerg0.name = "zerg0";

        Protos pronos1 = new Protos();
        pronos1.name = "protos1";
        Protos pronos2 = new Protos();
        pronos2.name = "protos2";
        Protos pronos3 = new Protos();
        pronos3.name = "protos3";
        Protos pronos4 = new Protos();
        pronos4.name = "protos4";
        Protos pronos5 = new Protos();
        pronos5.name = "protos5";

        Terran terran1 = new Terran();
        terran1.name = "terran1";
        Terran terran2 = new Terran();
        terran2.name = "terran2";
        Terran terran3 = new Terran();
        terran3.name = "terran3";
        Terran terran4 = new Terran();
        terran4.name = "terran4";
        Terran terran5 = new Terran();
        terran5.name = "terran5";
        Terran terran6 = new Terran();
        terran6.name = "terran6";
        Terran terran7 = new Terran();
        terran7.name = "terran7";
        Terran terran8 = new Terran();
        terran8.name = "terran8";
        Terran terran9 = new Terran();
        terran9.name = "terran9";
        Terran terran10 = new Terran();
        terran10.name = "terran10";
        Terran terran11 = new Terran();
        terran11.name = "terran11";
        Terran terran12 = new Terran();
        terran12.name = "terran12";
        //напишите тут ваш код

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}