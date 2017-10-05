package com.javarush.task.task21.task2113;

import java.util.LinkedList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            horses.add(new Horse("Horse #" +i,3,0));
        }
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse h: this.horses){
            h.move();
        }
    }

    public void print(){
        for (Horse h : this.horses){
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        double maxDistance = 0;
        Horse winner = null;
        for (Horse h : this.horses){
            if (h.getDistance() > maxDistance){
                maxDistance = h.getDistance();
                winner = h;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
