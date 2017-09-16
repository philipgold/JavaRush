package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filenama1 = br.readLine();
        String filenama2 = br.readLine();
        FileInputStream fisF1 = new FileInputStream(filenama1);
        FileWriter fwF2 = new FileWriter(filenama2);
        StringBuilder sb = new StringBuilder();

        while (fisF1.available()>0)
            sb.append((char)fisF1.read());

        String[] numbers = sb.toString().split(" ");

        for (String number : numbers){
            String val = Long.toString(Math.round(Double.parseDouble(number)));
            fwF2.write(val + " ");
        }
        fisF1.close();
        fwF2.close();


    }
}
