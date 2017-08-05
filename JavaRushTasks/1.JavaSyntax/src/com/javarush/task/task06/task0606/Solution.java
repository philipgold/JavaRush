package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sNumber = br.readLine();

        for (int i = 0; i < sNumber.length(); i++) {
            int n = Integer.parseInt(String.valueOf(sNumber.charAt(i)));
            if ((n%2) == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even: "+ even +" Odd: "+odd);
    }
}
