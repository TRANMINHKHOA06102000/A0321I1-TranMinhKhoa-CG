package com.codegym.repository.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager
                .createQuery(" select c from Customer c", Customer.class)
                .getResultList();
    }

    @Override
    public Customer findById(Long id) {
        try {
            return entityManager
                    .createQuery("select c from Customer c where c.id=:id", Customer.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }

    }

    @Override
    public void save(Customer model) {
        if(model.getId() != null){
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if(customer != null){
            entityManager.remove(customer);
        }
    }
}
