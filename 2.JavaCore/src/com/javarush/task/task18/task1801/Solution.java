package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filePath = br.readLine();
        //String filePath = "c://my-object-data.txt";

        FileInputStream fis = new FileInputStream(filePath);

        int max=Integer.MIN_VALUE;
        int data;
        while (fis.available()>0){
            if (max < (data = fis.read()))
                max = data;
        }
        System.out.println(max);
        br.close();
        fis.close();

    }
}
