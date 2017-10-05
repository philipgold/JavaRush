package com.javarush.task.task22.task2203;

/* 
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string ==null || string.isEmpty() || string.split("(\\t)").length <1)
            throw new TooShortStringException();

        int count=0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '\t')
                count++;
        }
        if (count<2)
            throw new TooShortStringException();


        int indexFist = string.indexOf("\t"), indexLast = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '\t')
                indexLast++;
            if (indexLast>1){
                indexLast = i;
                break;
            }



        }
        String t =string.substring(indexFist +1, indexLast);
        return t;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
