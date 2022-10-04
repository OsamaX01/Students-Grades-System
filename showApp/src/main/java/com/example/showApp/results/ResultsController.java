package com.example.showApp.results;

import com.example.showApp.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultsController {
    private final ResultsService resultsService;
    private final AuthenticationService authenticationService;

    @Autowired
    public ResultsController(ResultsService resultsService, AuthenticationService authenticationService) {
        this.resultsService = resultsService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/results")
    public String showResults(Model model) {
        if (!authenticationService.isAuthenticated()) {
            return "login";
        }

        Results results = resultsService.getResultsData();
        model.addAttribute("results", results);
        return "results";
    }
}
