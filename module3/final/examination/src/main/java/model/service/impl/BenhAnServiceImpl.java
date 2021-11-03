package model.service.impl;

import model.bean.BenhAn;
import model.repositories.BenhAnRepositories;
import model.repositories.impl.BenhAnRepositoriesImpl;
import model.service.BenhAnService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenhAnServiceImpl implements BenhAnService {
    BenhAnRepositories benhAnRepositories = new BenhAnRepositoriesImpl();

    @Override
    public List<BenhAn> findAll() {
        return benhAnRepositories.findAll();
    }

    @Override
    public void delete(int id) {
        benhAnRepositories.delete(id);
    }

    @Override
    public BenhAn findById(int id) {
        return benhAnRepositories.findById(id);
    }

    @Override
    public Map<String, String> edit(BenhAn benhAn) {
        Map<String, String> mapMessage = new HashMap<>();
        benhAnRepositories.update(benhAn);
        return mapMessage;
    }


}
