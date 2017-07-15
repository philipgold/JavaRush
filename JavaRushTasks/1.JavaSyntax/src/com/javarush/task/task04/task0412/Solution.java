package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sNumber = bufferedReader.readLine();

        int number = Integer.parseInt(sNumber);

        if (number >0)
            number = number * 2;

        if (number <0)
            number = number + 1;

        if (number == 0)
            number = 0;


        System.out.println(number);



    }

}