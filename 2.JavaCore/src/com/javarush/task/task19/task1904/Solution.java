package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
//        String sourceFile = "c://my-object-data.txt";
//        PersonScanner ps = new PersonScannerAdapter(new Scanner(new File(sourceFile)));
//
//        Person p = ps.read();
//        ps.close();

    }

    public static class PersonScannerAdapter implements PersonScanner  {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String lastName = this.fileScanner.next();
            String firstName = this.fileScanner.next();
            String middleName = this.fileScanner.next();
            //Date birthDate = new
            String dates = this.fileScanner.next();
            String months = this.fileScanner.next();
            String years = this.fileScanner.next();
            SimpleDateFormat sdf  = new SimpleDateFormat("dd MM yyyy");
            Date date = sdf.parse(String.format( "%s %s %s", dates, months, years));

            Person p = new Person(firstName, middleName, lastName, date);

            return p;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
