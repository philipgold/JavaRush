package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        if ((a <= 0) || (b <= 0))
            throw new Exception();
        gcd(a,b);


    }

    public static void gcd(int a, int b) {
        if (a > b) a = a - b; else b = b - a;
        if (b == 0)
        {
            System.out.println(a);
            return;
        }
        gcd(a, b);
    }
}

