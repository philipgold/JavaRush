package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg[] zerg = new Zerg[10];
        for (int z=0; z<10; z++){
            zerg[z] = new Zerg();
            zerg[z].name = "Zerg"+z;
        }

        Protoss[] protoss = new Protoss[5];
        for (int p =0; p<5; p++){
            protoss[p] = new Protoss();
            protoss[p].name = "Protoss" + p;
        }

        Terran[] terran = new Terran[12];
        for (int t=0; t<12; t++){
            terran[t] = new Terran();
            terran[t].name = "Terran" + t;
        }
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
