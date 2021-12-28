package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/showForm")
    public String showCustomerForm(Model modelObj){
        modelObj.addAttribute("customer",new Customer());

        return "customer-form";
    }
    @RequestMapping("/processForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customerobj, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "customer-form";
        }else {
            System.out.println("Last Name:"+customerobj.getLastName() + ",First Name:" + customerobj.getFirstName());
            return "customer-confirmation";
        }
    }

}
