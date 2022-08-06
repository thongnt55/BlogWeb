package com.reljicd.service.impl;

import com.reljicd.model.Post;
import com.reljicd.model.User;
import com.reljicd.repository.PostRepository;
import com.reljicd.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Optional<Post> findByTitle(String title) {
        return postRepository.findByTitleLike(title);
    }

    @Override
    public Optional<Post> findByBody(String body) {
        return postRepository.findByBodyLike(body);
    }

    @Override
    public Optional<Post> findByDescription(String description) {
        return postRepository.findByDescriptionLike(description);
    }

    @Override
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
        return postRepository.findByUserOrderByCreateDateDesc(user, PageRequest.of(subtractPageByOne(page), 5));
    }

    @Override
    public Page<Post> findByNameLike(String name,int page) {
        return postRepository.findByNameLike(name,PageRequest.of(subtractPageByOne(page), 5));
    }

    @Override
    public Page<Post> findAllOrderedByDatePageable(int page) {
        return postRepository.findAllByOrderByCreateDateDesc(PageRequest.of(subtractPageByOne(page), 5));
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void deleteById(long id) {

    }

//    @Override
//    public Optional<Post> findForCategory(String category) {
//        return Optional.empty();
//    }


//    @Override
//    public Page<Post> findForCategory(String category, int page) {
//        return postRepository.findByCategory(category,PageRequest.of(subtractPageByOne(page), 5));
//    }

    private int subtractPageByOne(int page){
        return (page < 1) ? 0 : page - 1;
    }
}
