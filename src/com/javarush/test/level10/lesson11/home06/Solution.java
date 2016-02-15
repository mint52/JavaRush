package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private String sex;
        private int age;
        private int rost;
        private int ves;
        private int razmer;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String sex, String name)
        {
            this.sex = sex;
            this.name = name;
        }

        public Human(String name, String sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, String sex, int age, int razmer)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.razmer = razmer;
        }

        public Human(String name, String sex, int age, int rost, int ves, int razmer)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.rost = rost;
            this.ves = ves;
            this.razmer = razmer;
        }

        public Human(String name, int razmer)
        {
            this.name = name;
            this.razmer = razmer;
        }

        public Human(String name, int razmer, int age, int ves)
        {
            this.name = name;
            this.razmer = razmer;
            this.age = age;
            this.ves = ves;
        }

        public Human(String name, String sex, int age, int rost, int ves)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.rost = rost;
            this.ves = ves;
        }

        public Human(int age, String sex, int rost, int ves, int razmer)
        {
            this.age = age;
            this.sex = sex;
            this.rost = rost;
            this.ves = ves;
            this.razmer = razmer;
        }

        public Human(String sex, int razmer, int age)
        {
            this.sex = sex;
            this.razmer = razmer;
            this.age = age;
        }
        //напишите тут ваши переменные и конструкторы
    }
}
