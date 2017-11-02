package com.javarush.task.task35.task3512;

/**
Генератор объектов
Разберись с текущими классами.
Метод newInstance класса Generator должен создавать Event для каждого нового вызова, однако сейчас компилятор ругается на синтаксис.
Переделай класс Generator так, что бы конструкция стала рабочей.

Подсказка: Для создания объекта потребуется использовать метод Class<T>.newInstance().
*/
public class Solution {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Generator<Event> eventGenerator = new Generator<>(Event.class);

        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
    }

}
