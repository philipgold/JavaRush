package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        int countEngLetters = 0;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] bytes = new byte[bis.available()];
        bis.read(bytes);

        for (byte b : bytes){
            if (Character.isLetter((char)b)
                    && Character.toString((char)b).matches("[a-zA-Z]"))
                countEngLetters ++;
        }
        System.out.println(countEngLetters);
        bis.close();
    }
}
