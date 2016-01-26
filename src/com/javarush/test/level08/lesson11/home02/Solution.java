package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.+
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.+
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.+
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution

{
    public static class Cat
    {

    }
    public static class Dog
    {

    }

    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> dog = new HashSet<Dog>();
        dog.add(new Dog());
        dog.add(new Dog());
        dog.add(new Dog());
        //напишите тут ваш код
        return dog;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        Set<Object> pets = new HashSet<Object>(); //Написать тут ваш код
        Iterator<Cat>literator=cats.iterator();
        while(literator.hasNext()){
            Cat t = literator.next();
            pets.add(t);
        }
        Iterator<Dog>iterator=dogs.iterator();
        while(iterator.hasNext()){
            Dog t = iterator.next();
            pets.add(t);
        }
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        Iterator<Cat> qwer = cats.iterator();
        while (qwer.hasNext())
        {
            Cat d = qwer.next();
            pets.remove(d);
        }
        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets)
    {
        for (Object p : pets)
        {

            System.out.println(p);
        }
        //напишите тут ваш код
    }


    //напишите тут ваш код
}
