package com.demo.controller;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;
import com.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        //create model attribute to bind the form data
        Customer theCustomer = new Customer();

        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }
}
