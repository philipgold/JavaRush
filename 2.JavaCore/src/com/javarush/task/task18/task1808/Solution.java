package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fin = reader.readLine();
        String fout2 = reader.readLine();
        String fout3 = reader.readLine();
        FileInputStream in = new FileInputStream(fin);
        FileOutputStream out2 = new FileOutputStream(fout2);
        FileOutputStream out3 = new FileOutputStream(fout3);



        while(in.available() > 0){
            if(in.available() % 2 == 0){
                byte[] o1 = new byte[in.available()/2];
                byte[] o2 = new byte[in.available()/2];
                int count1 = in.read(o1);
                int count2 = in.read(o2);
                out2.write(o1, 0, count1);
                out3.write(o2, 0, count2);
            } else {
                byte[] o1 = new byte[in.available()/2 + 1];
                byte[] o2 = new byte[in.available()/2];
                int count1 = in.read(o1);
                int count2 = in.read(o2);
                out2.write(o1, 0, count1);
                out3.write(o2, 0, count2);
            }
        }

        reader.close();
        in.close();
        out2.close();
        out3.close();
    }


}
