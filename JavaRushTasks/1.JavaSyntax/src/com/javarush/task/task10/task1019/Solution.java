package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int id = Integer.parseInt(reader.readLine());
//        String name = reader.readLine();
//
//        System.out.println("Id=" + id + " Name=" + name);
        HashMap<String, Integer> map = new HashMap<>();
        while (true){
            String sId = reader.readLine();
            if (sId.isEmpty())
                break;

            String name = reader.readLine();
            if (name.isEmpty())
                break;

            map.put(name, Integer.parseInt(sId));
        }
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}