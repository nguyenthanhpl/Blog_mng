package com.example.blog_mng.Model;

import javax.persistence.*;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ID;
    private String title;
    private String cover;
    private String content;

    public Blog(Long ID, String title, String cover, String content) {
        this.ID = ID;
        this.title = title;
        this.cover = cover;
        this.content = content;
    }

    public Blog() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
