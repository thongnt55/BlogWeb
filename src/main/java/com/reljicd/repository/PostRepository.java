package com.reljicd.repository;

import com.reljicd.model.Category;
import com.reljicd.model.Post;
import com.reljicd.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);
    Page<Post> findByCategoryOrderByCreateDate(Category category, Pageable pageable);

    @Query(value = "select * from POST where ( title like %:name% or body like %:name% or description like %:name% )", nativeQuery = true)
    Page<Post> findByNameLike(@Param("name") String name , Pageable pageable );
    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

    //Page<Post> findByCategory(String category, Pageable pageable);


    Optional<Post> findById(Long id);
    Optional<Post> findByBodyLike(String body);
    Optional<Post> findByDescriptionLike(String description);
    Optional<Post> findByTitleLike(String title);

}
