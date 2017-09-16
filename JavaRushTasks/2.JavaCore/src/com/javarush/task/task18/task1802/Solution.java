package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filepath = br.readLine();
        //String filepath = "c://my-object-data.txt";
        FileInputStream fis = new FileInputStream(filepath);

        int min = Integer.MAX_VALUE;
        int data;
        while (fis.available()>0){
            if (min > (data = fis.read()))
                min = data;
        }
        System.out.println(min);
        br.close();
        fis.close();
    }
}
