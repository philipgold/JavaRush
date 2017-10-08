package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public University(String name, int age) {

    }




    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s : this.students){
            if (s.getAverageGrade() == averageGrade)
                return s;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = Double.MIN_VALUE;
        int studentIndex = 0;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getAverageGrade()> maxAverageGrade) {
                maxAverageGrade = this.students.get(i).getAverageGrade();
                studentIndex = i;
            }
        }
        return this.students.get(studentIndex);
    }
    
    public Student getStudentWithMinAverageGrade(){
        double minAverageGrade = Double.MAX_VALUE;
        int studentIndex = 0;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getAverageGrade()< minAverageGrade) {
                minAverageGrade = this.students.get(i).getAverageGrade();
                studentIndex = i;
            }
        }
        return this.students.get(studentIndex);
    }

    public void expel(Student student){
        this.students.remove(student);
    }
}