package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            wheels = new ArrayList<>();
            if (loadWheelNamesFromDB().length !=4)
                throw new Exception();

            for (int i = 0; i < loadWheelNamesFromDB().length; i++) {
                String s = loadWheelNamesFromDB()[i];
                if (Wheel.valueOf(s).ordinal()!=-1)
                    wheels.add(Wheel.valueOf(s));

            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        Car c = new Car();
    }
}
