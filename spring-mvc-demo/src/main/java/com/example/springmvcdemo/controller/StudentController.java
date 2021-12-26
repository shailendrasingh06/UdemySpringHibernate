package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student") //parent mapping
public class StudentController {
    @RequestMapping("/showform")
    public String showForm(Model model){
        //create a student object
        Student studentObj = new Student();
        model.addAttribute("student", studentObj);

        return "student-form";
    }

    @RequestMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student studentObj) {
        //log the data
        System.out.println("Student Name: " + studentObj.toString());

        return "student-confirmation";
    }

}
