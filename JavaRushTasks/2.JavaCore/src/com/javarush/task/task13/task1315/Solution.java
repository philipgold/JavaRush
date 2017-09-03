package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        MyClass myClass = new MyClass();
        OutputStream outputStream = new FileOutputStream("c:/my-object-data.txt");
        myClass.write(13);

        while (myClass.available() >0){
            int data = myClass.read();
            try {
                outputStream.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        outputStream.close();
    }
    public static class MyClass {
        private ArrayList<Integer> list;

        MyClass(){
            list = new ArrayList();
        }
        public void write(int data){
            list.add(data);
        }
        public int read(){
            int first = list.get(0);
            list.remove(0);
            return first;
        }
        public int available(){
            return list.size();
        }
    }

}