package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
    }

    public static void checkInterval(int a) {
        //::CODE:
        //50 до 100
        if ((a>=50)&&(a<=100)){
            System.out.println("Число " + a + " содержится в интервале.");
        }
        else {
            System.out.println("Число " + a + " не содержится в интервале.");
        }
        //Число а не содержится в интервале.» или «Число а содержится в интервале.
    }
}