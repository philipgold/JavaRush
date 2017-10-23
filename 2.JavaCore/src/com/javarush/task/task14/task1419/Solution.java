package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();
        FilenotFound_Demo();
        Unchecked_Demo();
        ArrayStoreException_Demo();
        ClassCastException_Demo();
        NullPointerException_Demo();
        NegativeArraySizeException_Demo();
        NumberFormatException_Demo();
        StringIndexOutOfBoundsException_Demo();
        IndexOutOfBoundsException_Demo();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
    private static void FilenotFound_Demo() {
        try {
            File file = new File("E://file.txt");
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e2) {
            exceptions.add(e2);
        }
    }

    private static void Unchecked_Demo() {
        try {
            int num[] = {1, 2, 3, 4};
            System.out.println(num[5]);
        } catch (ArrayIndexOutOfBoundsException e3) {
            exceptions.add(e3);
        }
    }

    private static void ArrayStoreException_Demo() {
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (ArrayStoreException e4) {
            exceptions.add(e4);
        }
    }


    private static void ClassCastException_Demo() {
        String s = null;
        try {
            Object x = new Integer(0);
            s = (String) x;
        } catch (ClassCastException e5) {
            exceptions.add(e5);
        }
    }

    private static void NullPointerException_Demo() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e6) {
            exceptions.add(e6);
        }
    }

    private static void NegativeArraySizeException_Demo() {
        int a = -10;
        int b = -1000;
        try {
            int[] asd = new int[a + b];

        } catch (NegativeArraySizeException e7) {
            exceptions.add(e7);
        }

    }

    private static void NumberFormatException_Demo() {
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException e8) {
            exceptions.add(e8);
        }

    }

    private static void StringIndexOutOfBoundsException_Demo() {
        try {
            String str = "easysteps2buildwebsite";
            System.out.println(str.length());
            char c = str.charAt(0);
            c = str.charAt(40);
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e9) {
            exceptions.add(e9);
        }

    }

    private static void IndexOutOfBoundsException_Demo() {
        int[] a = new int[1];
        try {
            int z = a[10];
        } catch (IndexOutOfBoundsException e10) {
            exceptions.add(e10);
        }
    }
}
