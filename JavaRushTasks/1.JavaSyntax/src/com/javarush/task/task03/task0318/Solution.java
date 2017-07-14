package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sAge = reader.readLine();
        int nAge = Integer.parseInt(sAge);
        String s = reader.readLine();



        System.out.println(s + " захватит мир через " + nAge + " лет. Му-ха-ха!");
    }
}
