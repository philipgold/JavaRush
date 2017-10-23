package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {


    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        int count = tokenizer.countTokens();
        String[] strings = new String[count];

        for (int i = 0; i < count ; i++) {
            strings[i] = tokenizer.nextToken();
        }

        return strings;
    }
}
