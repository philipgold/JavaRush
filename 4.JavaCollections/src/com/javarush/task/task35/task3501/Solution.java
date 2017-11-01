package com.javarush.task.task35.task3501;
/**
Вызов статического метода
 Измени статический метод в классе GenericStatic так, чтобы он стал дженериком.
 Пример вызова дан в методе main.
*/
public class Solution {
    public static void main(String[] args) {
        Number number = GenericStatic.<Number>someStaticMethod(new Integer(3));
    }
}
