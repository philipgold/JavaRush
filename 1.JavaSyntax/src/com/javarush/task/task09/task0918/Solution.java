package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends Error {
    }

    static class MyException2 extends  IOException {
    }

    static class MyException3 extends NullPointerException {
    }

    static class MyException4 extends Exception {
    }
}

