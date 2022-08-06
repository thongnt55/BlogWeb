package com.reljicd.repository;

import com.reljicd.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryName(@Param("categoryName") String categoryName);

}
