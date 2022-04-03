package com.demo.dao;

import com.demo.entity.Customer;
import org.hibernate.HibernateException;
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

        // Inbuilt hibernate method to save or update based upon the primary key
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(long id) {

        Session tempSession = sessionFactory.getCurrentSession();

        Customer customer = tempSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(long id) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:theId");

        query.setParameter("theId", id);

        query.executeUpdate();

    }

    @Override
    public List<Customer> searchCustomers(String searchValue) {

        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        if (searchValue != null && searchValue.trim().length() > 0) {
            query = session.createQuery("from Customer where lower(first_name) like :searchFirstName OR lower(last_name) like :searchLastName", Customer.class);
            query.setParameter("searchFirstName", "%" + searchValue + "%");
            query.setParameter("searchLastName", "%" + searchValue + "%");

        }else {
            query = session.createQuery("from Customer ", Customer.class);
        }

        List<Customer> customers = query.list();
        return customers;
    }

}
