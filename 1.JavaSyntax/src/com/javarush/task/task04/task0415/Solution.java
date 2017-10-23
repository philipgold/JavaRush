package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sSizeA = bufferedReader.readLine();
        String sSizeB = bufferedReader.readLine();
        String sSizeC = bufferedReader.readLine();

        int sizeA = Integer.parseInt(sSizeA);
        int sizeB =Integer.parseInt(sSizeB);
        int sizeC = Integer.parseInt(sSizeC);

        if (sizeA < sizeB +sizeC && sizeB < sizeA + sizeC && sizeC < sizeA + sizeB)
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");

    }
}