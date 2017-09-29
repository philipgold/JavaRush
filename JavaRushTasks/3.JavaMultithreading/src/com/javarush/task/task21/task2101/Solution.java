package com.javarush.task.task21.task2101;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
Определяем адрес сети
1. Даны IP-адрес и маска подсети, необходимо вычислить адрес сети — реализуй метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).

Пример:
IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)

2. Реализовать метод print, который выведет в консоль данные в двоичном коде. Для IP-адреса(192.168.1.2)
должна быть выведена строка «11000000 10101000 00000001 00000010»
3. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[]netadress = new byte[4];
        for (int i = 0; i < 4; i++) {
            byte x = ip[i];
            byte y = mask[i];
            byte z = (byte) (x&y);
            netadress[i]=z;
        }
        return netadress;
    }

    public static void print(byte[] bytes) {
        for (byte b : bytes){
            System.out.print(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1) + " ");
        }
        System.out.println();
    }
}
