package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String file = args[0];
        BufferedReader br = new BufferedReader(new FileReader(file));

        while (br.ready()) {
            String line = br.readLine();
            PEOPLE.add(new Person(findName(line), findBirthday(line)));
        }
        br.close();

    }
    private static String findName(String line){
//        String name = line.split("(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s((19|20)\\d\\d)")[0];
        String name = "";


        Pattern p = Pattern.compile("(\\D+)");
        Matcher m = p.matcher(line);
        if (m.find())
            name = m.group(0).trim();
        return name;
    }

    private static Date findBirthday(String line) throws ParseException {
        Date birthday = new Date();
        Pattern p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s((19|20)\\d\\d)");
        Matcher m = p.matcher(line);
        if (m.find()){
            String b = m.group(0);
            birthday = new SimpleDateFormat("dd MM yyyy").parse(b);
        }
        return birthday;
    }
}
