package model.service;

import model.bean.BenhAn;

import java.util.List;
import java.util.Map;

public interface BenhAnService {
    List<BenhAn> findAll();

    void delete(int id);

    BenhAn findById(int id);

    Map<String, String> edit(BenhAn benhAn);
}
