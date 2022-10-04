package com.example.analytics.students;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsDataRowMapper implements RowMapper<StudentsData> {
    @Override
    public StudentsData mapRow(ResultSet resultSet, int i) throws SQLException {
        return new StudentsData(
                resultSet.getDouble("maxMark"),
                resultSet.getDouble("minMark"),
                resultSet.getDouble("studentsAverage")
        );
    }
}