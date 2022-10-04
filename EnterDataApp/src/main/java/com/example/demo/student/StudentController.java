package com.example.demo.student;

import com.example.demo.authentication.AuthenticationService;
import com.example.demo.authentication.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final AuthenticationService authenticationService;

    @Autowired
    StudentController(StudentService studentService, AuthenticationService authenticationService) {
        this.studentService = studentService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (authenticationService.isAuthenticated()) {
            return "loggedIn";
        }

        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {
        authenticationService.authenticate(user);
        if (!authenticationService.isAuthenticated()) {
            return "invalidCredentials";
        }

        return "redirect:";
    }

    @GetMapping("/add")
    public String studentForm(Model model) {
        if (!authenticationService.isAuthenticated()) {
            return "redirect:login";
        }

        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/add")
    public String studentSubmit(@ModelAttribute Student student, Model model) {
            if (!authenticationService.isAuthenticated()) {
                return "redirect:login";
            }

            studentService.addStudent(student);
            return "addResult";
    }
}