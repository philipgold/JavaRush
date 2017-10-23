package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int countP=0, countN =0;

        if (a>0)
            countP ++;
        else if (a<0)
            countN ++;

        if (b>0)
            countP++;
        else if (b<0)
            countN++;

        if (c>0)
            countP++;
        else if (c<0)
            countN ++;

        //System.out.println("количество отрицательных чисел: " + countN);
        //System.out.println("количество положительных чисел: " + countP);

        System.out.println("количество отрицательных чисел: "+countN);
        System.out.println("количество положительных чисел: "+countP);
    }

}
