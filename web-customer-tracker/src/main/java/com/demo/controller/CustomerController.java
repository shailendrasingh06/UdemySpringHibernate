package com.demo.controller;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject the dao into this controller
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomer(Model theModel) {

        //get the customers from dao
        List<Customer> list = customerDAO.getCustomers();

        //add the customers into the model

        theModel.addAttribute("customers", list);
        return "list-customers";
    }
}
