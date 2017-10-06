package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }
    public List<User> getUsers(){
        return new AbstractDbSelectExecutor<User>(){


            @Override
            public String getQuery() {
                return null;
            }
        };
    }

    public List<Location> getLocations(){
        return new AbstractDbSelectExecutor<Location>(){

            @Override
            public String getQuery() {
                return null;
            }
        };
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}
