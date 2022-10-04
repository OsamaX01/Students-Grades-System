package com.example.showApp.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResultsService {
    private final JdbcTemplate jdbc;

    @Autowired
    public ResultsService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Results getResultsData() {
        return jdbc.query("SELECT * FROM results", new ResultsRowMapper()).get(0);
    }
}
