package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filepath = br.readLine();
        //String filepath = "c://my-object-data.txt";
        FileInputStream fis = new FileInputStream(filepath);
        ArrayList<Integer> bytes = new ArrayList<>();

        int data;
        while (fis.available()>0){
            if (!bytes.contains(data = fis.read()))
                bytes.add(data);
        }
        Collections.sort(bytes);

        for (Integer i : bytes)
            System.out.print(i + " ");
        br.close();
        fis.close();
    }
}
