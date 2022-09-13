package com.example.blog_mng.Controller;

import com.example.blog_mng.Model.Blog;
import com.example.blog_mng.Model.BlogForm;
import com.example.blog_mng.Model.Category;
import com.example.blog_mng.Service.BlogService.BlogService.BlogService;
import com.example.blog_mng.Service.BlogService.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/blog")
//@CrossOrigin("*")

public class Blog_Controller {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Value("${upload.path}")
    private String fileUpload;


    @GetMapping("")
    public String index (Model model){
        model.addAttribute("blog",blogService.findAll());
        return "index";
    }

    @GetMapping("/add-blog")
    public ModelAndView addBlog() {
        ModelAndView modelAndView = new ModelAndView("/add-blog");
        modelAndView.addObject("blog", new BlogForm());
        return modelAndView;
    }

//    @PostMapping("/add-blog")
//    public RedirectView createBLog(@ModelAttribute BlogForm blog){
//            Blog blog1 = new Blog.BlogBuilder(blog.getName())
//                .(blog.getImage()).build();
//        MultipartFile multipartFile = blog.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(blog.getImage().getBytes(), new File(this.fileUpload + fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        blog.setImage(fileName);
//        blogService.save(blog1);
//        return new RedirectView("");
//    }



    @PostMapping("/add-blog")
    public RedirectView saveBlog(@ModelAttribute BlogForm blogForm){
        Blog blog = new Blog;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editBlog(@PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit-blog");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        } else {
            return new ModelAndView("/warning");
        }
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit-blog");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("Thông báo","Cập nhật thành công");
//        ModelAndView.addObject("blog",blog);
//        ModelAndView.addObject();
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable("id") long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/delete-blog");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;

        } else {
            return new ModelAndView("/warning");
        }
    }

    @PostMapping("/detete")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getID());
        return "redirect:blogs";
    }



}
