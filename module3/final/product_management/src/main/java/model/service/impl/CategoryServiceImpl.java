package model.service.impl;

import model.bean.Category;
import model.repositories.CategoryRepositories;
import model.repositories.impl.CategoryRepositoriesImpl;
import model.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepositories categoryRepositories = new CategoryRepositoriesImpl();
    @Override
    public List<Category> findAll() {
        return categoryRepositories.findAll();
    }
}
