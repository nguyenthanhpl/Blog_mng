package com.example.blog_mng.Model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BlogForm {

    private Long id;
    private String name;
    //private String description;
    private MultipartFile image;

    public BlogForm() {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public BlogForm(BlogFormBuilder blogFormBuilder) {
    }

    public static  class BlogFormBuilder{
        private final String name;

        private String description;

        private MultipartFile image;

        public BlogFormBuilder(String name) {
            this.name = name;
        }

        public BlogFormBuilder image(MultipartFile image){
            this.image = image;
            return this;
        }

        public BlogForm build(){
            return new BlogForm(this);
        }
    }
}
