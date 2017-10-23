package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        //напишите тут ваш код
        Human h1 = new Human("дедушкa1", true,56);
        Human h2 = new Human("дедушкa2", true,57);
        Human h3 = new Human("бабушка1", false,58);
        Human h4 = new Human("бабушка2", false,59);
        Human h5 = new Human("отец", true,55, h1, h3);
        Human h6 = new Human("мать", false,55, h2, h4);
        Human h7 = new Human("ребенок1", false,4, h5, h6);
        Human h8 = new Human("ребенок2", false,3, h5, h6);
        Human h9 = new Human("ребенок3", true,2,h5, h6);


        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(h3.toString());
        System.out.println(h4.toString());
        System.out.println(h5.toString());
        System.out.println(h6.toString());
        System.out.println(h7.toString());
        System.out.println(h8.toString());
        System.out.println(h9.toString());


    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        //напишите тут ваш код


        public String toString() {
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






















