package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arrBig = new int[20];
        int[] arrSmall1 = new int[10];
        int[] arrSmall2 = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arrBig.length; i++) {
            arrBig[i] = Integer.parseInt(br.readLine());
        }
        System.arraycopy(arrBig,0, arrSmall1,0,10);
        System.arraycopy(arrBig,10, arrSmall2,0,10);
        for (int i = 0; i < arrSmall2.length; i++) {
            System.out.println(arrSmall2[i]);
        }

    }
}
