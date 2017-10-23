package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            //напишите тут ваш код
            String s = "Недовес: меньше чем 18.5";
            String m = "Нормальный: между 18.5 и 24.9";
            String l = "Избыточный вес: между 25 и 29.9";
            String xl = "Ожирение: 30 или больше";

            double index = weight / (height * height);

            System.out.println(index < 18.5 ? s : (index >= 18.5 && index <= 24.9 ? m : (index >= 25 && index <= 29.9 ? l : (index >= 30 ? xl : ""))));
        }
    }
}
