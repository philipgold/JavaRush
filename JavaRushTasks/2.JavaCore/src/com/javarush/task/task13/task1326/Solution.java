package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String fname = br.readLine();
            //String fname = "c://my-object-data.txt";
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
            ArrayList<Integer> list = new ArrayList<>();

            while (br.ready()) {
                int i = Integer.parseInt(br.readLine());
                if (i % 2 == 0)
                    list.add(i);
            }

            Collections.sort(list);
            for (int i : list) {
                System.out.println(i);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            br.close();
        }





    }
}
