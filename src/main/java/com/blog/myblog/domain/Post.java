package com.blog.myblog.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Posts")
public class Post {
    @GeneratedValue
    @Id
    private long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Date date;
    @ManyToOne
    private User user;

    public Post(){}
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
