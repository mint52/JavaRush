package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> chil = new ArrayList<Human>();
        Human qwer = new  Human("qwer", true, 5);
        Human zerg =new Human("zerg", false, 6);
        Human ork =new Human("ork", true, 2);
        chil.add(qwer);
        chil.add(zerg);
        chil.add(ork);

        Human pap = new Human("pap",true,55,chil);
        Human mam = new Human("mam",false,50,chil);

        ArrayList<Human> pm = new ArrayList<Human>();
        pm.add(pap);
        pm.add(mam);

        Human gf1 =new Human("ded1",true,90,pm);
        Human gf2 =new Human("ded2",true,92,pm);
        Human gm1 =new Human("bab1",false,91,pm);
        Human gm2 =new Human("bab1",false,95,pm);

        System.out.println(pap);
        System.out.println(mam);
        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
        System.out.println(qwer);
        System.out.println(zerg);
        System.out.println(ork);



        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;

        }
        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
