package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String allLinesFile = br.readLine();
            String removeLinesFile = br.readLine();

            //String allLinesFile = "c://my-object-data.txt";
            //String removeLinesFile = "c://my-object-data-2.txt";

            br = new BufferedReader(new FileReader(allLinesFile));
            while (br.ready())
                allLines.add(br.readLine());

            br = new BufferedReader(new FileReader(removeLinesFile));
            while (br.ready())
                forRemoveLines.add(br.readLine());

            br.close();

        Solution solution = new Solution();
        solution.joinData();



    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else if (allLines.size() > 0) {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
