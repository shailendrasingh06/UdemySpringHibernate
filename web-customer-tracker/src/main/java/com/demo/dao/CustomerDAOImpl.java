package com.demo.dao;

import com.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;   //inject the session factory object

    @Override
    public List<Customer> getCustomers() {

        List<Customer> customerList = new ArrayList<>();

        //get the current hibernate session

        Session session = sessionFactory.getCurrentSession();
        //create a query

        Query<Customer> query = session.createQuery("from Customer order by last_name", Customer.class);

        //execute the query and get the results

        customerList = query.getResultList();


        return customerList;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.save(customer);
    }
}
