package com.example.demo.student;

public class Student {
    private long id;
    private String name;
    private double totalGrades;

    public Student() { }

    public Student(long id, String name, double totalGrades) {
        this.id = id;
        this.name = name;
        this.totalGrades = totalGrades;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalGrades() {
        return totalGrades;
    }

    public void setTotalGrades(double totalGrades) {
        this.totalGrades = totalGrades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalGrades=" + totalGrades +
                '}';
    }
}