package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        int countLetters = 0, countSpaces =0;


        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] bytes = new byte[bis.available()];
        bis.read(bytes);
        for (byte b : bytes){
            countLetters++;
            if (Character.isWhitespace((char)b))
                countSpaces ++;
        }
        double result = (double)countSpaces/countLetters*100;
        System.out.printf("%.2f", result);
        bis.close();

    }
}
