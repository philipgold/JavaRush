package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String fileName;

        while (!(fileName = br.readLine()).equals("exit")){
            list.add(fileName);
            ReadThread rt = new ReadThread(fileName);
            rt.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);

                Map<Integer,Integer> map = new HashMap<>();

                while (fis.available()>0){
                    int i = fis.read();
                    if (!map.containsKey(i))
                        map.put(i, 1);
                    else
                        map.put(i, map.get(i)+1);
                }
                Map.Entry<Integer, Integer> maxEntry = null;
                for (Map.Entry<Integer, Integer> pair : map.entrySet()){
                    if (maxEntry == null || pair.getValue().compareTo(maxEntry.getValue())>0)
                        maxEntry = pair;
                }

                resultMap.put(fileName, maxEntry.getKey());
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
