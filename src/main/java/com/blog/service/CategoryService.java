package com.blog.service;

import com.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();
    Optional<Category> findByCategoryName(String categoryName);

}
