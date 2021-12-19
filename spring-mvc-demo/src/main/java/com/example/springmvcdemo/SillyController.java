package com.example.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/sillyPage")  //Parent Mapping
public class SillyController {

    @RequestMapping("/showForm")  //sub-mapping
    public String displayForm(){
        return "silly-form";
    }

    @RequestMapping("processFormVersionThree")
    private String convertToUpperCase(@RequestParam("username") String name, Model model) {

        //read the request param from the html form using @RequestParam annotation
        String UpperName = name.toUpperCase();

        //add the data in to the model object
        model.addAttribute("message", UpperName + " Hello there buddy!!!" + " Coding done by " + HelloWorldController.getSIGNATURE());

        return "helloworld";
    }
}
