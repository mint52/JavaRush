package com.javarush.test.level20.lesson10.home02;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws Exception
    {
        if (objectStream.readObject() instanceof A)
            return  (A) objectStream.readObject();
        else return (B) objectStream.readObject();

    }
    public Solution(){}
    public class A {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
