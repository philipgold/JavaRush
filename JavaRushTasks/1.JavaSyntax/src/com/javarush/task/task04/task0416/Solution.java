package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double min = Double.parseDouble(bufferedReader.readLine());
        double r = min % 5;

        if (r<3){
            System.out.println("зелёный");
        }
        else  if ( r<4){
            System.out.println("желтый");
        }
        else
        {
            System.out.println("красный");
        }
    }
}