package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        if ( n == 0)
            System.out.println("ноль");
        else if ( n % 2 == 0 ){
            //even
            if (n<0)
                System.out.println("отрицательное четное число");
            else
                System.out.println("положительное четное число");
        }
        else  {
            //odd
            if (n<0)
                System.out.println("отрицательное нечетное число");
            else
                System.out.println("положительное нечетное число");
        }
    }
}
