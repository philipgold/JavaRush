package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> ai = new ArrayList<>();
        int[] m = new int[10];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
            ai.add(Integer.parseInt(r.readLine()));
        int c = 1;//counter
        for (int i = 0; i < 9; i++) {
            if(ai.get(i) == ai.get(++i)) {
                c += 1;//increments the counter of this sequence
                i--;}//returns index of list due to ++i
            else {
                m[i] = c;
                c = 1;//zeroes a counter
                i--;}//checks a previous element
        }
        m[9] = c;//adds last value of the counter
/*        for (int i = 0; i < m.length; i++)//for checking
            System.out.println(m[i]);*/
        Arrays.sort(m);
/*        for (int i = 0; i < m.length; i++)//for checking
            System.out.println(m[i]);*/
        System.out.println(m[9]);
    }
}