package com.javarush.task.task17.task1710;


import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    public static int id;
    public static String name;
    public static Sex sex;
    public static Date bd;


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //Parse arguments
        parcelArguments(args);

        if (args[0].equals("-c"))
            createPerson(name, sex, bd);
        else if (args[0].equals("-u"))
            updatePerson(id, name, sex, bd);
        else if (args[0].equals("-d"))
            deletePerson(id);
        else if (args[0].equals("-i"))
            printPerson(id);
    }

    private static void parcelArguments(String[] args) {
        try{
            if (args.length == 0)
                throw new IllegalArgumentException("There is no arguments");

            String action = args[0];


            if (action.equals("-c")){
                name = args[1];
                if (args[2].equals("м"))
                    sex = Sex.MALE;
                else if (args[2].equals("ж"))
                    sex = Sex.FEMALE;
                bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]);
            }
            else if (action.equals("-u")) {
                id = Integer.parseInt(args[1]);
                name = args[2];
                if (args[3].equals("м"))
                    sex = Sex.MALE;
                else if (args[3].equals("ж"))
                    sex = Sex.FEMALE;
                bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]);

            }
            else if (action.equals("-d") | action.equals("-i"))
                id = Integer.parseInt(args[1]);



        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void createPerson(String name, Sex sex, Date bd){

        if (sex == Sex.MALE)
            allPeople.add(Person.createMale(name,bd));

        else if (sex == Sex.FEMALE)
            allPeople.add(Person.createFemale(name,bd));

        System.out.println(allPeople.size() - 1);
    }

    private static void updatePerson(int id, String name, Sex sex, Date bd){
        allPeople.get(id).setName(name);
        allPeople.get(id).setSex(sex);
        allPeople.get(id).setBirthDay(bd);
    }

    private static void deletePerson(int id){
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    private static void printPerson(int id){
        Person p = allPeople.get(id);

        String s = String.format("%s %s %s", p.getName(), p.getSex() == Sex.MALE ? "м" : "ж", new SimpleDateFormat("dd-MMM-yyyy").format(p.getBirthDay()));
        System.out.println(s);
    }




}
