package com.demo.controller;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;
import com.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/customer",method = RequestMethod.GET) // or we can use @GetMapping("/customer")
public class CustomerController {

    //inject the dao into this controller
    @Autowired
    private CustomerService customerService;  //Inject the customer service

    @PostMapping("/list")
    public String listCustomer(Model theModel) {

        //get the customers from customer Service
        List<Customer> list = customerService.getCustomers();

        //add the customers into the model

        theModel.addAttribute("customers", list);
        return "list-customers";
    }
}
