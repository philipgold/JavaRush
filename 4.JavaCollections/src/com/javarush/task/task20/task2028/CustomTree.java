package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    Entry<String> entryRoot = new Entry<String>("0");
    final Queue<Entry<String>> queue = new LinkedList<>();
    {
        queue.add(entryRoot);
    }

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }


    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }


    public boolean add(int index, String element) {
        return false;
    }



    //@Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
//        return super.remove(index);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }

    @Override
    public int size() {
        return 0;
    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddRightChildren = true;
            this.availableToAddLeftChildren = true;
        }

        void checkChildren(){
            if (this.leftChild !=null)
                this.availableToAddLeftChildren = false;
            if (this.rightChild != null)
                this.availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren(){
            //возвращающет дизъюнкцию полей availableToAddLeftChildren и availableToAddRightChildren.
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }
}
