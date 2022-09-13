package com.example.blog_mng.Repo;

import com.example.blog_mng.Model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}
