package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

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

        while (br.ready()) {
            String line;
            line = br.readLine();
            String id = line.substring(0, 8);
            String productName = line.substring(8, 38);
            String price = line.substring(38, 46);
            String quantity = line.substring(46, 50);
            products.add(new Product(id, productName, price, quantity));
        }

        br.close();


        if (!(args.length > 0)) {
            return;
        } else if (args[0].equals("-u")) {
            Product updateProduct = new Product(args[1], args[2], args[3], args[4]);
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == updateProduct.getId()){
                    Product np = products.get(i);
                    np.productName = updateProduct.productName;
                    np.price = updateProduct.price;
                    np.quantity = updateProduct.quantity;
                    products.set(i, np);
                    break;
                }
            }

        } else if (args[0].equals("-d")) {
            Product updateProduct = new Product(args[1], "", "", "");
            for (Product p : products) {
                if (p.getId() == updateProduct.getId()) {
                    products.remove(p);
                    break;
                }
            }
        }
        // Add new product
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourcefile)));

        for (Product product : products) {
            bw.write(product.toString());
            bw.newLine();
        }
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