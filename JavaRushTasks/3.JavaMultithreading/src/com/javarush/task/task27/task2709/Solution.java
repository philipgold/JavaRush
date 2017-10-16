package com.javarush.task.task27.task2709;

/* 
Producer–consumer
В классе TransferObject расставь вызовы методов wait/notify/notifyAll, чтобы обеспечить последовательное создание и получение объекта.
В методах run классов ConsumerTask и ProducerTask создай необходимые synchronized блоки.

Ожидаемый вывод:
...
Put: M
Got: M
Put: N
Got: N
Put: K
Got: K
...
где M, N, K — числа
Метод main не участвует в тестировании

P.S. Всегда старайся использовать concurrent коллекции вместо ручной реализации wait/notify/notifyAll.
Задачи подобные этой позволяют лучше понять основы работы многопоточных приложений.
*/
public class Solution {
    public static void main(String args[]) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        ProducerTask producerTask = new ProducerTask(transferObject);
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
}
