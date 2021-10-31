package model.service.impl;

import model.bean.CustomerType;
import model.repositories.CustomerTypeRepository;
import model.repositories.impl.CustomerTypeRepositoryImpl;
import model.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> findALl() {
        return customerTypeRepository.findALl();
    }
}
