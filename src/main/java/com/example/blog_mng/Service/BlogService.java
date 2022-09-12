package com.example.blog_mng.Service;

import com.example.blog_mng.Model.Blog;
import com.example.blog_mng.Repo.BlogRepo;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepo blogRepo;

    public List<Blog> getAll(){
        return (List<Blog>) blogRepo.findAll();
    }

    public Blog add(Blog blog) {
        return blogRepo.save(blog);
    }

    public Boolean delete(long id) {
        try {
            blogRepo.deleteById(id);
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            return false;
        }
        return true;
    }

    public Blog update(long id, Blog blog) {
        Blog blog1 = blogRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog not exits " + id));
        if (blog1 != null) {
            blog1.setTitle(blog.getTitle());
            blog1.setCover(blog.getCover());
            blog1.setContent(blog.getContent());
            return blogRepo.save(blog1);
        }
        return null;
    }


    public Object getBlog(long id) {
        return blogRepo.findById(id).get();
    }
}
