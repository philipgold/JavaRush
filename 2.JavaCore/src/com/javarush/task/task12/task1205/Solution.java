package com.javarush.task.task12.task1205;

/*
Определимся с животным
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String result = "Неизвестное животное";
        if (o instanceof Cow)
            result = "Корова";
        else if (o instanceof Whale)
            result = "Кит";
        else if (o instanceof Dog)
            result = "Собака";
        return result;
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
