package com.reljicd.service.impl;

import com.reljicd.model.Category;
import com.reljicd.repository.CategoryRepository;
import com.reljicd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
