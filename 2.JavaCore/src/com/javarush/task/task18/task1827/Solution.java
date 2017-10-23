package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id — 8 символов.
productName — название товара, 30 chars (60 bytes).
price — цена, 8 символов.
quantity — количество, 4 символа.
-c — добавляет товар с заданными параметрами в конец файла, outгенерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00 12
198478  Шорты пляжные черные с рисунко173.00 17
19847983Куртка для сноубордистов, разм10173.991234
*/

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sourcefile = br.readLine();
//        String sourcefile = "C://my-object-data.txt";

        //Get products
        ArrayList<Product> products = new ArrayList<>();
        br = new BufferedReader(new InputStreamReader(new FileInputStream(sourcefile)));

        while (br.ready()){
            String line;
            line = br.readLine();
            String id = line.substring(0,8);
            String productName = line.substring(8,38);
            String price = line.substring(38,46);
            String quantity = line.substring(46,50);
            products.add(new Product(id,productName, price, quantity));
        }

        br.close();


        if (!(args.length > 0)){
            return;
        }

        // Add new product
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourcefile)));

        for (Product product : products){
            bw.write(product.toString());
            bw.newLine();
        }
        int id = products.get(products.size()-1).getId()+1;
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        Product p = new Product(String.valueOf(id),productName,price,quantity);

        bw.write(p.toString());
        bw.close();

    }

    public static class Product {
        private String id;
        private String productName;
        private String price;
        private String quantity;

        public Product(String id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return Integer.parseInt(id.trim());
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-8.8s", this.id));
            sb.append(String.format("%-30.30s", this.productName));
            sb.append(String.format("%-8.8s", this.price));
            sb.append(String.format("%-4.4s", this.quantity));
            return sb.toString();
        }
    }
}
