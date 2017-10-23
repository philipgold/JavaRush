package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int sum = 0;
        int [] argumets ={a,b,c};

        Arrays.sort(argumets);                                                              // сортируем полученный массив
        System.out.println(argumets[1]);


//        for (int i = 0; i < argumets.length; i++) {
//            sum += argumets[i];
//        }
//        int average = sum/argumets.length;
//        System.out.println(average);



    }
}
