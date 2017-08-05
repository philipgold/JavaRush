package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String t = reader.readLine();
        int i = Integer.parseInt(reader.readLine());
        int y = 0;

        while (y <i){
            System.out.println(t);
            y++;
        }
    }
}
