package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private JdbcTemplate jdbc;

    @Autowired
    public StudentService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> getStudents()  {
        List<Student> students = jdbc.query("SELECT * FROM students", new StudentRowMapper());
        return students;
    }

    public void addStudent(Student student) {
        int result = jdbc.update("INSERT INTO students(name, totalGrades) VALUES(?,?)", student.getName(), student.getTotalGrades());
        if (result != 1) {
            throw new IllegalStateException("something went wrong :( ");
        }
    }
}