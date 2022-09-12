package com.example.blog_mng.Controller;

import com.example.blog_mng.Model.Blog;
import com.example.blog_mng.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Blog_Controller {

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String index (Model model){
        model.addAttribute("blog",blogService.getAll());
        return "index";
    }

    @GetMapping("/add-blog")
    public String addBlog(Blog blog, Model model) {
        model.addAttribute("blog", new Blog());
        return "add-blog";
    }

    @PostMapping("/add-blog")
    public String addBlog(Blog blog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-blog";
        }
        blogService.add(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable("id") long id, Model model) {
        model.addAttribute("blog", blogService);
        return "edit-blog";
    }

    @PostMapping("/update/{id}")
    public String editBlog( @ModelAttribute("blog") long id, Blog blog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("blog",blog);
            return "edit_blog";
        }
        blogService.update(blog.getID(),blog);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") long id, Model model) {
        model.addAttribute("blog", blogService.getBlog(id));
        return "redirect:/index";
    }
}
