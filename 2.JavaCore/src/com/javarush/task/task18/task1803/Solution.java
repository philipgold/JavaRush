package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filepath = br.readLine();
        //String filepath = "c://my-object-data.txt";
        FileInputStream fis = new FileInputStream(filepath);
        ArrayList<Integer> bytes = new ArrayList<>();

        while (fis.available()>0){
            bytes.add(fis.read());
        }
        br.close();
        fis.close();

        HashMap<Integer, Integer> map = new HashMap<>();
        initMapBytesCount(bytes, map);

        print(map, getMaxCount(map));
    }

    private static void print(HashMap<Integer, Integer> map, int maxCount){

        for(Map.Entry<Integer, Integer> pair : map.entrySet() )
        {
            if (pair.getValue() == maxCount)
                System.out.print(pair.getKey() + " ");
        }
    }

    private static int getMaxCount(HashMap<Integer, Integer> map) {
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue()> maxCount)
                maxCount = pair.getValue();
        }
        return maxCount;
    }

    public static void initMapBytesCount(ArrayList<Integer> bytes, HashMap<Integer, Integer> map) {
        for (int i = 0; i < bytes.size(); i++) {
            int countSameBytes = 0;

            for (int j = i+1; j < bytes.size() ; j++) {
                if (bytes.get(j).equals(bytes.get(i)))
                    countSameBytes++;
            }

            boolean contains = false;
            
            for(Map.Entry<Integer, Integer> pair: map.entrySet()){
                if (pair.getKey().equals(bytes.get(i)))
                    contains = true;
            }
            if (!contains)
                map.put(bytes.get(i), countSameBytes);

        }
    }
}
