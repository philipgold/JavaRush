package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] arr = new int[15];
//        int even = 0, odd = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (i==0 ){
//                even +=arr[i];
//            }
//            else if ( (arr[i]%2)== 0)
//                even +=arr[i];
//            else
//                odd+=arr[i];
//        }
//        if (even > odd)
//            System.out.println("В домах с четными номерами проживает больше жителей.");
//        else
//            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        //напишите тут ваш код
        int[] dom = new int [15];
        int sch_chet = 0;
        int sch_nechet = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            dom[i] = Integer.parseInt(bf.readLine());
            if (i % 2 == 0 | i == 0)
                sch_chet = sch_chet + dom[i];
            else
                sch_nechet = sch_nechet + dom[i];
        }
        if (sch_chet > sch_nechet)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");




    }
}
