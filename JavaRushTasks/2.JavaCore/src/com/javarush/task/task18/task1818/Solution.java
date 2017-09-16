package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        String fileName3 = br.readLine();

        FileOutputStream fosF1 = new FileOutputStream(fileName1);
        FileInputStream fisF2 = new FileInputStream(fileName2);
        FileInputStream fisF3 = new FileInputStream(fileName3);

        while (fisF2.available()>0)
            fosF1.write(fisF2.read());
        while ((fisF3.available()>0))
            fosF1.write(fisF3.read());

        fosF1.close();
        fisF2.close();
        fisF3.close();


    }
}
