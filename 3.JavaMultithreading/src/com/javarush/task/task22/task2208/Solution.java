package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        boolean needAnd = false;
        for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue() != null) {
                if (needAnd) sb.append(" and ");
                sb.append(String.format("%s = '%s'", pair.getKey(), pair.getValue()));
                needAnd = true;

            }
        }

        return sb.toString();
    }
}
