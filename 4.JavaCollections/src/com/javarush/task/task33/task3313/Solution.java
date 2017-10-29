package com.javarush.task.task33.task3313;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
Сериализация даты в JSON
 Используя аннотацию JsonFormat сделай так, чтобы поле содержащее дату в классе Event сериализировалось в формате (dd-MM-yyyy hh:mm:ss).
*/
public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        Event event = new Event("event#1");

        String result = new ObjectMapper().writeValueAsString(event);

        System.out.println(result);
    }
}
