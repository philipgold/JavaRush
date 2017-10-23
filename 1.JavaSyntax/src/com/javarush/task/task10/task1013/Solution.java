package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String sFistName;
        private String sLastName;
        private int age;
        private boolean sex;
        private String adress;
        private String phone;

        public Human(){}
        public Human(String sFistName, String sLastName){
            this.sFistName = sFistName;
            this.sLastName = sLastName;
        }
        public Human(int age){
            this.age = age;
        }
        public Human(boolean sex){
            this.sex = sex;
        }

        public Human(String adress, boolean sex){
            this.adress = adress;
            this.sex = sex;
        }
        public Human(String phone){
            this.phone = phone;
        }

        public Human( String sFistName, String sLastName, int age){
            this.sFistName = sFistName;
            this.sLastName = sFistName;
            this.age = age;
        }
        public Human( String sFistName, String sLastName, int age, boolean sex){
            this.sFistName = sFistName;
            this.sLastName = sFistName;
            this.age = age;
            this.sex = sex;
        }
        public Human( String sFistName, String sLastName, int age, boolean sex, String adress){
            this.sFistName = sFistName;
            this.sLastName = sFistName;
            this.age = age;
            this.sex = sex;
            this.adress = adress;
        }
        public Human( String sFistName, String sLastName, int age, boolean sex, String adress, String phone){
            this.sFistName = sFistName;
            this.sLastName = sFistName;
            this.age = age;
            this.sex = sex;
            this.adress = adress;
            this.phone = phone;
        }



    }
}
