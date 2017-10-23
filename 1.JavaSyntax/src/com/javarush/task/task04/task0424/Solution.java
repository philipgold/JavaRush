package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));

        int  a = Integer.parseInt(bufferedReader.readLine());
        int  b = Integer.parseInt(bufferedReader.readLine());
        int  c = Integer.parseInt(bufferedReader.readLine());
        if(a==b)
            System.out.println("3");

        if(a==c)
            System.out.println("2");

        if(c==b)
            System.out.println("1");
    }
}
