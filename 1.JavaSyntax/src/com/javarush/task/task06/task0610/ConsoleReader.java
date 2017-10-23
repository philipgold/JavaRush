package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
        return  bri.readLine();
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bri.readLine());
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(bri.readLine());
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
        return Boolean.parseBoolean(bri.readLine());
    }

    public static void main(String[] args) {

    }
}
