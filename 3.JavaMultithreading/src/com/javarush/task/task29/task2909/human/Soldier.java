package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    //TODO:  Перенеси в Soldier необходимые методы из Human.

    public Soldier(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {
        fight();
    }

    public void fight() {

    }
}
