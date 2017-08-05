package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> humans = new ArrayList<>();
        ArrayList<Human> children = new ArrayList<>();
        children.add(new Human("Child 1", false, 2, new ArrayList<>()));
        children.add(new Human("Child 2", true, 3, new ArrayList<>()));
        children.add(new Human("Child 3", false, 4, new ArrayList<>()));


        Human father = new Human("Father", true, 33, children);
        Human mother = new Human("Mother", false, 30, children);

        ArrayList<Human> children1 = new ArrayList<>();
        children1.add(father);
        //children1.add(mother);

        ArrayList<Human> children2 = new ArrayList<>();
        children2.add(mother);
        //children2.add(father);



        Human grandFather1 = new Human("Grand Father 1", true, 65, children1);
        Human grandMother1 = new Human("Grand Mother 1", false, 65, children1);

        Human grandMother2 = new Human("Grand Mother 2", false, 66, children2);
        Human grandFather2 = new Human("Grand Father 2", true, 66, children2);

        humans.addAll(children);
        humans.add(father);
        humans.add(mother);
        humans.add(grandFather1);
        humans.add(grandFather2);
        humans.add(grandMother1);
        humans.add(grandMother2);



        for (int i = 0; i < humans.size(); i++) {
            System.out.println(humans.get(i).toString());
        }
        //System.out.println(humans.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children ;

        public Human(String name, Boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
