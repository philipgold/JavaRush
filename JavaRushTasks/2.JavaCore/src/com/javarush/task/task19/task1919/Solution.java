package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = args[0];
        BufferedReader br = new BufferedReader(new FileReader(file));
        Map<String, Double> map = new TreeMap<>();

        while (br.ready()){
            String line = br.readLine();
            String name = line.split("\\s")[0];
            double nValue = Double.parseDouble(line.split("\\s")[1]);
            if (!map.containsKey(name))
                map.put(name, nValue);
            else {
                double oValue = map.get(name);
                map.put(name, oValue + nValue);
            }
        }
        br.close();

        for (Map.Entry<String, Double> pair : map.entrySet())
            System.out.println(String.format("%s %s", pair.getKey(), Double.toString(pair.getValue())));
    }
}
