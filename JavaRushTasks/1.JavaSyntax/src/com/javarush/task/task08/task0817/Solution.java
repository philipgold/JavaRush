package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Last Name 0", "First Name 1");
        map.put("Last Name 1", "First Name 1");
        map.put("Last Name 2", "First Name 2");
        map.put("Last Name 3", "First Name 3");
        map.put("Last Name 4", "First Name 4");
        map.put("Last Name 5", "First Name 5");
        map.put("Last Name 6", "First Name 6");
        map.put("Last Name 7", "First Name 7");
        map.put("Last Name 8", "First Name 3");
        map.put("Last Name 9", "First Name 2");

        //for (int i = 2; i < 10; i++) {
        //    map.put("Last Name " +i, "First Name " +i);
        //}
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashSet<String> list = new HashSet<>();
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()){
            if (!list.add(pair.getValue()))
                removeItemFromMapByValue(map,pair.getValue());

        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());

    }
}
