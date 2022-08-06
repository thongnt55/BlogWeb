package com.reljicd.controller;

import com.reljicd.model.Category;
import com.reljicd.model.Post;
import com.reljicd.service.CategoryService;
import com.reljicd.service.PostService;
import com.reljicd.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    private final PostService postService;
    public CategoryController(CategoryService categoryService, PostService postService) {
        this.categoryService = categoryService;
        this.postService = postService;
    }

    @RequestMapping(value = "/home/{categoryName}", method = RequestMethod.GET)
    public String blogForUsername(@PathVariable String categoryName,
                                  @RequestParam(defaultValue = "0") int page,
                                  Model model) {

        Optional<Category> category1 = categoryService.findByCategoryName(categoryName);

        Category category = category1.get();
            Page<Post> posts = postService.findByCategoryOrderedByDatePageable(category, page);
            Pager pager = new Pager(posts);

            model.addAttribute("pager", pager);
            model.addAttribute("category", category);

            return "/home";


    }
}
