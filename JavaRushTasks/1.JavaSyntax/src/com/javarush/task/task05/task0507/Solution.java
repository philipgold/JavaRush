package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        int a = 0;
        while (true) {
            int number = Integer.parseInt(br.readLine());
            a++;
            if (number == -1) {
                break;
            }
            sum += number;
        }
        System.out.println(sum / (a - 1));
    }
}

