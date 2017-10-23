package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int number = Integer.parseInt(reader.readLine());
            if (number == -1) {
                break;
            }
            sum += number;
        }
        System.out.println(sum - 1);
    }
}
