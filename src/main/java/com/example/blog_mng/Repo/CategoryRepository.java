package com.example.blog_mng.Repo;

import com.example.blog_mng.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
