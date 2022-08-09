package com.reljicd.controller;

import com.reljicd.model.Category;
import com.reljicd.model.Post;
//import com.reljicd.model.Tag;
import com.reljicd.repository.CategoryRepository;
//import com.reljicd.repository.TagRepository;
import com.reljicd.service.PostService;
import com.reljicd.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final PostService postService;
    private final CategoryRepository categoryRepository;
//    private final TagRepository tagRepository;

    @Autowired
    public HomeController(PostService postService, CategoryRepository categoryRepository) {
        this.postService = postService;
        this.categoryRepository = categoryRepository;
//        this.tagRepository = tagRepository;
    }

    @GetMapping("/home")
    public String home(@RequestParam(defaultValue = "0") int page,
                       Model model) {

        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
        Pager pager = new Pager(posts);

        model.addAttribute("pager", pager);

        List<Category> categories = categoryRepository.findAll();
        //System.out.println("categories: "+categories);
        model.addAttribute("categories",categories);



        return "/home";
    }

    @GetMapping("/search")
    public String home_search(@RequestParam(defaultValue = "0") int page,@RequestParam( name = "name", defaultValue = "0") String name,
                       Model model) {

        System.out.println(name);
        Page<Post> posts = postService.findByNameLike(name,page);
        Pager pager = new Pager(posts);

        model.addAttribute("pager", pager);

        List<Category> categories = categoryRepository.findAll();
        //System.out.println("categories: "+categories);
        model.addAttribute("categories",categories);


        return "/home";
    }


    @GetMapping("/searchtag")
    public String tag_search(@RequestParam(defaultValue = "0") int page,@RequestParam( name = "name", defaultValue = "0") String name,
                              Model model) {

        System.out.println(name);
        Page<Post> posts = postService.findByTagLike(name,page);
        Pager pager = new Pager(posts);

        model.addAttribute("pager", pager);

        return "/home";
    }
//    @GetMapping("/index")
//    public String index(@RequestParam(defaultValue = "0") int page,
//                       Model model) {
//
//        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
//        Pager pager = new Pager(posts);
//
//        model.addAttribute("pager", pager);
//
//        return "/index";
//    }
}
