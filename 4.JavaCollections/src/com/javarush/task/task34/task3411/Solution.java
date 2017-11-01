package com.javarush.task.task34.task3411;

/**
Ханойские башни
 Имеется три стержня. На стержень A нанизаны count колец, причем кольца отличаются размером и лежат меньшее на большем. Требуется перенести пирамиду из count колец с стержня A на стержень B за наименьшее число ходов.
 За один раз разрешается переносить только одно кольцо, причем нельзя класть большее кольцо на меньшее.
 Нужно реализовать публичный статический метод void moveRing(char a, char b, char c, int count), который выведет последовательность действий, необходимых для перемещения колец со стержня A на стержень B.

 Параметры метода:
 char a — имя стержня, на котором в начале находятся все кольца;
 char b — имя стержня, на который нужно перенести все кольца;
 char c — имя вспомогательного стержня;
 int count — общее количество колец, которые необходимо перенести.
 Задачу нужно решать используя рекурсивный вызов метода moveRing.

 Пример1:
 Метод moveRing вызывается с параметрами: ‘A‘, ‘B‘, ‘C‘, 1

 Ожидаемый вывод:
 from A to B

 Пример2:
 Метод moveRing вызывается с параметрами: ‘A‘, ‘B‘, ‘C‘, 3

 Ожидаемый вывод:
 from A to B
 from A to C
 from B to C
 from A to B
 from C to A
 from C to B
 from A to B

 Подсказка: общее количество действий равно 2 в степени count минус 1.
*/

public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char a, char b, char c, int count) {
        //напишите тут ваш код
        if(count>0){
            //a  - from
            //b - to
            //c - temp
            moveRing(a, c, b, count - 1);
            System.out.println("from " + a + " to " + b);
            moveRing(c, b,a, count - 1);
        }
    }
}