package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] arrS = new String[10];
        int[] arrN = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arrS.length; i++) {
            String t = br.readLine();
            arrS[i] = t;
            arrN[i] = t.length();
        }
        for (int i = 0; i < arrN.length; i++) {
            System.out.println(arrN[i]);

        }


    }
}
