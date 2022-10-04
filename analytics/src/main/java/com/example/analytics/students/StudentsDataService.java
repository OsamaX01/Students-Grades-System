package com.example.analytics.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class StudentsDataService {
    private final JdbcTemplate jdbc;

    @Autowired
    public StudentsDataService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // this is from https://www.sourcecodeexamples.net/2020/12/how-to-delete-data-from-mysql-table.html
    public void deleteRecord() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://mysqldb:3306/students", "root", "123456");
                Statement statement = connection.createStatement();
        ) {
            int counter = statement.executeUpdate("DELETE FROM results");
            System.out.println("Number of records affected :: " + counter);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StudentsData> getResultsData() {
        return jdbc.query("SELECT * FROM results", new StudentsDataRowMapper());
    }

    public void writeResults() {
        writeStudentsData(new StudentsData(getMaxMark(), getMinMark(), getAvgMark()));
    }

    private void writeStudentsData(StudentsData studentsData) {
        jdbc.update(
                "INSERT INTO results(maxMark, minMark, studentsAverage) VALUES(?, ?, ?)",
                studentsData.getMaxMark(),
                studentsData.getMinMark(),
                studentsData.getStudentsAverage()
        );
    }

    private double getMinMark() {
        return jdbc.queryForObject(
                "SELECT MIN(totalGrades) FROM students",
                double.class
        );
    }

    private double getMaxMark() {
        return jdbc.queryForObject(
                "SELECT MAX(totalGrades) FROM students",
                double.class
        );
    }

    private double getAvgMark() {
        return jdbc.queryForObject(
                "SELECT AVG(totalGrades) FROM students",
                double.class
        );
    }
}
