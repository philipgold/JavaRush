package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
//        String file1 = "c://my-object-data.txt";
        String file2 = br.readLine();
//        String file2 = "c://my-object-data-2.txt";


        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream((file2));

        //byte[] bytes = new byte[fis.available()];
        //fis.read(bytes);
        //Collections.reverse(Arrays.asList(bytes));
        //fos.write(bytes);

//        byte[] bytes = new byte[fis.available()];
//        fis.read(bytes);
//        for (int i = bytes.length - 1 ; i > 0; i--) {
//            fos.write(bytes[i]);
//        }

        while (fis.available()>0){
            byte[] bytes = new byte[fis.available()];
            int count = fis.read(bytes);

            for(int i = 0; i < bytes.length / 2; i++){
                byte tmp = bytes[i];
                bytes[i] = bytes[bytes.length-i-1];
                bytes[bytes.length-i-1] = tmp;
            }

            fos.write(bytes, 0, count);
        }

        fis.close();
        fos.close();
        br.close();


    }
}
