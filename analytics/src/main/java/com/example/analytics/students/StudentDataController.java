package com.example.analytics.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDataController {
    private final StudentsDataService studentsDataService;

    @Autowired
    public StudentDataController(StudentsDataService studentsDataService) {
        this.studentsDataService = studentsDataService;
    }

    @Scheduled(fixedRate = 2000)
    public StudentsData postAnalysis() {
        studentsDataService.deleteRecord();
        studentsDataService.writeResults();
        return studentsDataService.getResultsData().get(0);
    }
}
