package com.example.blog_mng.Service.BlogService.BlogService;

import com.example.blog_mng.Model.Blog;
import com.example.blog_mng.Repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
