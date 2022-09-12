package com.example.blog_mng.Repo;

import com.example.blog_mng.Controller.Blog_Controller;
import com.example.blog_mng.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepo extends CrudRepository<Blog, Long> {
}
