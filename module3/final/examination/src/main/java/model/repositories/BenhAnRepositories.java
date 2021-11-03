package model.repositories;

import model.bean.BenhAn;

import java.util.List;

public interface BenhAnRepositories {
    List<BenhAn> findAll();

    void delete(int id);

    void update(BenhAn benhAn);

    BenhAn findById(int id);
}
