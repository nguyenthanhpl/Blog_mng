package com.example.blog_mng.Service.BlogService.CategoryService;

import com.example.blog_mng.Model.Blog;
import com.example.blog_mng.Model.Category;
import com.example.blog_mng.Repo.BlogRepository;
import com.example.blog_mng.Repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
