package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = args[0];
        int maxValume = Integer.MIN_VALUE;
        BufferedReader br = new BufferedReader(new FileReader(file));
        Map<String, Double> map = new TreeMap<>();
        while (br.ready()){
            String line = br.readLine();
            String name =  line.split("\\s")[0];
            double value = Double.parseDouble(line.split("\\s")[1]);
            if (!map.containsKey(name))
                map.put(name, value);
            else {
                double oValue = map.get(name);
                map.put(name, value=(oValue + value));
            }
            if (maxValume < value)
                maxValume = (int)value;
        }
        br.close();

        for (Map.Entry<String , Double> pair : map.entrySet())
            if (pair.getValue() >= maxValume)
                System.out.println(pair.getKey());



    }
}
