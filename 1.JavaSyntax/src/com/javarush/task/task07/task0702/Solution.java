package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
        String [] list = new String[10];

        for (int i = 0; i < 8; i++) {
            list[i] = bri.readLine();
        }
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.println(list[i]);
        }
    }
}