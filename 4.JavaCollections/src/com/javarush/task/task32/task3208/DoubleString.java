package com.javarush.task.task32.task3208;

import java.rmi.RemoteException;

public interface DoubleString {
    String doubleString(String str) throws RemoteException;
}
