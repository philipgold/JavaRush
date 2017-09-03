package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        //String value = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        //String value = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        //String value = "http://javarush.ru/alpha/index.html?obj=test&name=Amigo";

        Map<String, String> quiry_pairs = splitQuery(value);

        for ( Map.Entry<String, String> pair : quiry_pairs.entrySet())
            System.out.print(pair.getKey() + " ");
        System.out.println();

        String objValue;
        if ((objValue = quiry_pairs.get("obj"))!= null){
            try {
                alert(Double.parseDouble(objValue));
            }
            catch (NumberFormatException e){
                alert(objValue);
            }
        }
    }

    public static Map<String, String> splitQuery(String sURL) throws UnsupportedEncodingException, MalformedURLException {
        Map<String, String> query_pairs = new LinkedHashMap();
        URL url = new URL(sURL);
        String query = url.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");

            String  s = idx > 0 ? pair.substring(0,idx) : pair;
            String key = URLDecoder.decode(s, "UTF-8");

            String s1 = idx > 0 ? pair.substring(idx + 1) : "";
            String value = URLDecoder.decode(s1, "UTF-8");

            query_pairs.put(key, value);
        }
        return  query_pairs;
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
