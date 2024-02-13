package com.demo.sbcruddemo.dao;

import com.demo.sbcruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        List<Employee> list ;

        Session session = entityManager.unwrap(Session.class);

        Query<Employee> employeeQuery = session.createQuery("from Employee", Employee.class);

        list = employeeQuery.getResultList();

        return list;
    }
}
