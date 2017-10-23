package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();
        //String file = "c://my-object-data.txt";
        FileInputStream fis = new FileInputStream(file);

        int commaCount = 0;
        while (fis.available()>0){
            char c = (char) fis.read();
            if (Character.toString(c).equals(","))
                commaCount++;
        }
        System.out.println(commaCount);
        fis.close();
    }
}
