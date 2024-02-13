package com.demo.sbcruddemo.dao;

import com.demo.sbcruddemo.entity.Employee;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeDAO{
    public List<Employee> findAll();
}
