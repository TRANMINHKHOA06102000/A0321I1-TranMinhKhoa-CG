package model.repositories;

import model.bean.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    List<CustomerType> findALl();
}
