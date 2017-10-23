package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
В файле your_file_name.tmp может быть несколько объектов JavaRush.
Метод main реализован только для вас и не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            //File backup = File.createTempFile("backup_22_01_2016", ".txt", new File("C:\\tmp"));
            File your_file_name = new File("c://my-object-data.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();

            User u1 = new User();
            u1.setFirstName("John");
            u1.setLastName("Travolta");
            u1.setBirthDate(new Date());
            u1.setMale(true);
            u1.setCountry(User.Country.UKRAINE);
            javaRush.users.add(u1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush);
            System.out.println(loadedObject);

            outputStream.close();
            inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataOutputStream dOS = new DataOutputStream(outputStream);
            dOS.writeInt(users.size());
            for (User user : users) {
                String firstname = (user.getFirstName() == null) ? "null" : user.getFirstName();
                dOS.writeUTF(firstname);
                String lastname = (user.getLastName() == null) ? "null" : user.getLastName();
                dOS.writeUTF(lastname);
                dOS.writeLong(user.getBirthDate().getTime());
                dOS.writeBoolean(user.isMale());
                dOS.writeUTF(user.getCountry().name());
            }
            dOS.flush();
        }
        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            DataInputStream dIS = new DataInputStream(inputStream);
            int usersCount = dIS.readInt();
            for (int i = 0; i < usersCount; i++) {
                User user = new User();
                String firstname = dIS.readUTF();
                if (firstname.equals("null")) firstname = null;
                user.setFirstName(firstname);
                String lastname = dIS.readUTF();
                if (lastname.equals("null")) lastname = null;
                user.setLastName(lastname);
                user.setBirthDate(new Date(dIS.readLong()));
                user.setMale(dIS.readBoolean());
                user.setCountry(User.Country.valueOf(dIS.readUTF()));
                this.users.add(user);
            }
        }

        @Override
        public String toString()
        {
            return "JavaRush { " + "users=" + users;
        }
    }
}