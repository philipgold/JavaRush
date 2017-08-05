package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        //напишите тут ваш код
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(reader.readLine());
            arr[i] = n;
            if (n < minimum)
                minimum = n;
            if (n> maximum)
                maximum = n;
        }
        System.out.println( maximum + " " + minimum);


        //System.out.println(maximum);
        //System.out.println(minimum);
    }
}
