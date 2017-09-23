package com.javarush.task.task19.task1915;

/* 
Дублируем текст
Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна дублировать вывод всего текста в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing


*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileDestination = br.readLine();
        br.close();
        FileOutputStream fos = new FileOutputStream(fileDestination);


        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));

        testString.printSomething();



        System.setOut(consoleStream);

        System.out.println(outputStream.toString());

        fos.write(outputStream.toByteArray());
        fos.close();


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

