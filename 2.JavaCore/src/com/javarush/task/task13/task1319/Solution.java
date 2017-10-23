package com.javarush.task.task13.task1319;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();
        //String fname = "c://my-object-data.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fname));


        String text = "";

        while (!text.equals("exit")){
            text = br.readLine();
            bw.write(text);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
