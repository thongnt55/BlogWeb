package com.blog.service;

import com.blog.model.Category;
import com.blog.model.Post;
import com.blog.model.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {

    Optional<Post> findForId(Long id);

    Optional<Post> findByTitle(String title);

    Optional<Post> findByBody(String body);

    Optional<Post> findByDescription(String description);
    Post save(Post post);

    /**
     * Finds a {@link Page) of {@link Post} of provided user ordered by date
     */
    Page<Post> findByUserOrderedByDatePageable(User user, int page);

    Page<Post> findByCategoryOrderedByDatePageable(Category category, int page);
    Page<Post> findByNameLike(String name, int page);
    /**
     * Finds a {@link Page) of all {@link Post} ordered by date
     */
    Page<Post> findAllOrderedByDatePageable(int page);

    void delete(Post post);

    void deleteById(long id);

    Page<Post> findByTagLike(String name, int page);

//    Optional<Post> findForCategory(String category);
//
//    Page<Post> findForCategory(String category, int page);
}
