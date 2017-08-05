package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        for (int i = 0; i < 9; i++) {
            map.put("Stallone" + i, new Date("JUNE 1 198"+i));
        }
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()){
            int month = it.next().getValue().getMonth();
            if (month ==5||
                    month==6 ||
                    month==7 ){
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        removeAllSummerPeople(createMap());

    }
}
