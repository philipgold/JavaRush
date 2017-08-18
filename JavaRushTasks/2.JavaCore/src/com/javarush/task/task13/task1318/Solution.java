package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



            FileInputStream inputStream = new FileInputStream(br.readLine());


        while (inputStream.available()>0){
                System.out.print((char)inputStream.read());
            }
            System.out.println();

            inputStream.close();
            br.close();


    }
}