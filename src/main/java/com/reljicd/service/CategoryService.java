package com.reljicd.service;

import com.reljicd.model.Category;
import com.reljicd.model.User;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();
    Optional<Category> findByCategoryName(String categoryName);

}
