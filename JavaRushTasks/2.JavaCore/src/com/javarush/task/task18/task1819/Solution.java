package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();

        FileInputStream fisF1 = new FileInputStream(fileName1);
        byte[] bytes = new byte[fisF1.available()];
        fisF1.read(bytes);

        FileOutputStream fosF1 = new FileOutputStream(fileName1);
        FileInputStream fisF2 = new FileInputStream(fileName2);

        while (fisF2.available()>0){
            fosF1.write(fisF2.read());
        }
        fosF1.write(bytes);

        fosF1.close();
        fisF1.close();
        fisF2.close();


    }
}
