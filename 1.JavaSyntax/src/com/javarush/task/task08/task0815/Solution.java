package com.javarush.task.task08.task0815;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("Last Name " + i, "First Name " + i);
        }
        return  map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        Iterator it= map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
            if (pair.getValue().equals(name))
                count ++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        Iterator it= map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
            if (pair.getKey().equals(lastName))
                count ++;
        }
        return count;
    }

    public static void main(String[] args) {


    }
}
