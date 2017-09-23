package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла — file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.

Пример:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка5            ADDED строка5
строка4         строка4            SAME строка4
строка5                            REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(file1));
        ArrayList<String> l1 = new ArrayList<>();
        while (br.ready())
            l1.add(br.readLine());
        br.close();

        br = new BufferedReader(new FileReader(file2));
        ArrayList<String> l2 = new ArrayList<>();
        while (br.ready())
            l2.add(br.readLine());
        br.close();

        int f1 =0;
        int f2 =0;

        while (f1<l1.size() && f2 < l2.size()){
            //если значения равны
            if (l1.get(f1).equals(l2.get(f2))){
                lines.add(new LineItem(Type.SAME, l1.get(f1)));
                f1++;
                f2++;
            }
            //если в первом файле сущ-ет следующая строка и эта строка равна текущей во втором файле
            else if (f1 + 1 < l1.size() && l1.get(f1 + 1).equals(l2.get(f2))){
                lines.add(new LineItem(Type.REMOVED, l1.get(f1)));
                f1++;
            }
            // если во втором сущ-ет следующая строка и эта строка равна текущей в первом
            else if (f2 + 1 < l2.size() && l2.get(f2 + 1).equals(l1.get(f1))){
                lines.add(new LineItem(Type.ADDED, l2.get(f2)));
                f2++;
            }
        }
        if (f1 <l1.size()){
            lines.add(new LineItem(Type.REMOVED, l1.get(f1)));
        }
        if (f2 < l2.size()){
            lines.add(new LineItem(Type.ADDED, l2.get(f2)));
        }

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).type.toString() + " " + lines.get(i).line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
