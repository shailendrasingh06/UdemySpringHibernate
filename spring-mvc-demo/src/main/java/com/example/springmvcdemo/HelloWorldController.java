package com.example.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    private String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    private String showHelloWorldPage() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    private String convertToUpperCase(HttpServletRequest request, Model model) {

        //read the request param from the html form and convert the name to upper case
        String name = request.getParameter("username").toUpperCase();

        String result = name;

        //add the data in to the model object
        model.addAttribute("message", result);

        return "helloworld";
    }

}
