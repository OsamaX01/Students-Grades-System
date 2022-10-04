package com.example.showApp.results;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultsRowMapper implements RowMapper<Results> {
    @Override
    public Results mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Results(
                resultSet.getDouble("maxMark"),
                resultSet.getDouble("minMark"),
                resultSet.getDouble("studentsAverage")
        );
    }
}