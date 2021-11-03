package model.service.impl;

import model.bean.BenhNhan;
import model.repositories.BenhNhanRepositories;
import model.repositories.impl.BenhNhanRepositoriesImpl;
import model.service.BenhNhanService;

import java.util.List;

public class BenhNhanServiceImpl implements BenhNhanService {
    BenhNhanRepositories benhNhanRepositories = new BenhNhanRepositoriesImpl();

    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepositories.findAll();
    }
}
