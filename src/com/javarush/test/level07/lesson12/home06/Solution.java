package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded = new Human("ded1", true, 98,null,null);
        Human ded2 = new Human("ded2", true, 95,null,null);
        Human bab1 = new Human("bab1", false, 94,null,null);
        Human bab2 = new Human("bab2", false, 92,null,null);
        Human otec = new Human("otec1", true, 45,ded,bab1);
        Human mom = new Human("mom", false, 40,ded2,bab2);
        Human kid1 = new Human("kid1", false, 15,otec,mom);
        Human kid2 = new Human("kid2", true, 16,otec,mom);
        Human kid3 = new Human("kid3", false, 5,otec,mom);

        System.out.println(ded);
        System.out.println(ded2);
        System.out.println(bab1);
        System.out.println(bab2);
        System.out.println(otec);
        System.out.println(mom);
        System.out.println(kid1);
        System.out.println(kid2);
        System.out.println(kid3);
        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human (String name,boolean sex, int age,Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
