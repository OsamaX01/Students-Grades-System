package com.example.showApp.results;

public class Results {
    private double maxMark;
    private double minMark;
    private double studentsAverage;

    public Results() { }

    public Results(double maxMark, double minMark, double studentsAverage) {
        this.maxMark = maxMark;
        this.minMark = minMark;
        this.studentsAverage = studentsAverage;
    }

    public double getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(double maxMark) {
        this.maxMark = maxMark;
    }

    public double getMinMark() {
        return minMark;
    }

    public void setMinMark(double minMark) {
        this.minMark = minMark;
    }

    public double getStudentsAverage() {
        return studentsAverage;
    }

    public void setStudentsAverage(double studentsAverage) {
        this.studentsAverage = studentsAverage;
    }

    @Override
    public String toString() {
        return "results{" +
                "maxMark=" + maxMark +
                ", minMark=" + minMark +
                ", studentsAverage=" + studentsAverage +
                '}';
    }
}
