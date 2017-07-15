package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));

        int  a = Integer.parseInt(bufferedReader.readLine());
        int  b = Integer.parseInt(bufferedReader.readLine());

        if(a > 0 && b > 0)
            System.out.println("1");

        if(a < 0 && b > 0 )
            System.out.println("2");

        if(a < 0 && b < 0 )
            System.out.println("3");

        if(a > 0 && b < 0 )
            System.out.println("4");
    }
}
