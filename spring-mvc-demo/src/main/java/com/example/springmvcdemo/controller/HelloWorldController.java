package com.example.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    private static String SIGNATURE = "Shailendra";

    public static HelloWorldController instance;

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

    @RequestMapping("/processFormVersionThree")
    private String convertToUpperCase(@RequestParam("username") String name, Model model) {

        //read the request param from the html form using @RequestParam annotation
        String UpperName = name.toUpperCase();

        //add the data in to the model object
        model.addAttribute("message", UpperName + " Hello there buddy!!!" + " Coding done by " + getSIGNATURE());

        return "helloworld";
    }

    public static String getSIGNATURE() {
        return SIGNATURE;
    }

}
