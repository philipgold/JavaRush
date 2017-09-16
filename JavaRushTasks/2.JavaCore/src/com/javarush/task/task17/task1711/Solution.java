package com.javarush.task.task17.task1711;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        checkArguments(args);

        switch (args[0]){
            case "-c": { synchronized(allPeople) {createPersons(args); break;}}
            case "-u": { synchronized(allPeople) {updatePersons(args); break;}}
            case "-d": { synchronized(allPeople) {deletePersons(args); break;}}
            case "-i": { synchronized(allPeople) {printPersons(args); break;}}
            //default: throw new IllegalArgumentException("Invalid first action parameter");
        }
    }

    private static void updatePersons(String[] args) {
        for (int i = 1; i < args.length; i+=4) {
                Person p = Person.createPerson(args[i + 1], args[i + 2], args[i + 3]);

                allPeople.get(Integer.parseInt(args[i])).setName(p.getName());
                allPeople.get(Integer.parseInt(args[i])).setSex(p.getSex());
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(p.getBirthDay());
        }
    }

    public static void deletePersons(String[] args){
        for (int i = 1; i < args.length; i++) {
                allPeople.get(Integer.parseInt(args[i])).setName(null);
                allPeople.get(Integer.parseInt(args[i])).setSex(null);
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);

        }
    }

    public static void printPersons(String[] args){
        for (int i = 1; i < args.length; i++) {
                Person p = allPeople.get(Integer.parseInt(args[i]));

                String s = String.format("%s %s %s", p.getName(), p.getSex() == Sex.MALE ? "м" : "ж", new SimpleDateFormat("dd-MMM-yyyy").format(p.getBirthDay()));
                System.out.println(s);
        }
    }

    private static void createPersons(String[] args) {
        Person p;
        for (int i = 1; i < args.length; i+=3) {
                p = Person.createPerson(args[i], args[i + 1], args[i + 2]);
                allPeople.add(p);
                System.out.println(allPeople.size() - 1);
        }
    }

    private static void checkArguments(String[] args) {
        try{
            if (args.length ==0)
                throw new IllegalArgumentException("There are no arguments");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
