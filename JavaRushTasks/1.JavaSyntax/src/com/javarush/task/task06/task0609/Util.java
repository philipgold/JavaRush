package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        double x = (x1-x2);
        double y= (y1-y2);
        double distance= Math.sqrt(x*x + y*y);
        return distance;
    }

    public static void main(String[] args) {

    }
}
