package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        StringBuilder sb = new StringBuilder();

        br.close();
        br = new BufferedReader(new FileReader(filename));
        ArrayList<String> strings = new ArrayList<>();
        while (br.ready()){
            strings.addAll(Arrays.asList(br.readLine().split("\\s")));

        }

        for (int i = 0; i < strings.size(); i++) {
            for (int j = 0; j < strings.size();) {
                String s = new StringBuilder(strings.get(i)).reverse().toString();
                if (strings.get(j).equals(s) && j!=i){
                    Pair p = new Pair();
                    p.first = strings.get(j);
                    p.second = strings.get(i);
                    result.add(p);
                    strings.remove(j);
                    strings.remove(i);
                    j = 0;
                }else
                    j ++;
            }
        }
        for (Pair p : result)
            System.out.println(p);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
