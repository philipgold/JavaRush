package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] texts = {"четное однозначное число",
        "нечетное однозначное число",
        "четное двузначное число",
        "нечетное двузначное число",
        "четное трехзначное число",
        "нечетное трехзначное число"};

        if (n <1 || n>999 )
            return;

        if (n % 2 ==0){
            //even
            if (n <=9)
                System.out.println(texts[0]);
            else if (n<=99)
                System.out.println(texts[2]);
            else  if (n<=999)
                System.out.println(texts[4]);

        }
        else {
            //odd
            if (n <=9)
                System.out.println(texts[1]);
            else  if (n<=99)
                System.out.println(texts[3]);
            else if (n<=999)
                System.out.println(texts[5]);
        }

    }
}
