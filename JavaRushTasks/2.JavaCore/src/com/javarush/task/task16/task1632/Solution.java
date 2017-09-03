package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList(5);
    static{
        threads.add(new myThread1());
        threads.add(new myThread2());
        threads.add(new myThread3());
        threads.add(new myThread4());
        threads.add(new myThread5());
    }

    public static void main(String[] args) {
    }

    public static class myThread1 extends Thread{
        public void run (){
            while (true){
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public  static class myThread2 extends Thread{
        public void run(){
            while (true){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }
    public  static class myThread3 extends Thread{
        public void run(){
            while (true){
                try {
                    System.out.println("Ура");
                    sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public  static class myThread4 extends Thread implements Message{
        public void run(){

        }

        @Override
        public void showWarning() {
            //Thread.currentThread().interrupt();
            interrupt();
        }
    }

    public static class myThread5 extends Thread{

        String text = "";
        int sum;
        public void run(){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (!(text = br.readLine()).equals("N")){
                    sum += Integer.parseInt(text);
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}