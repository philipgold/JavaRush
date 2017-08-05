package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        CharSequence searchR = "р";
        CharSequence searchL = "л";
        for (int i = list.size() - 1; i >= 0; i--) {
            String w = list.get(i);
            boolean r = w.contains(searchR);
            boolean l = w.contains(searchL);

            if (r && !l) {
                list.remove(i);
            }
            if (l && !r) {
                list.add(w);
            }
        }
        return list;
    }
}