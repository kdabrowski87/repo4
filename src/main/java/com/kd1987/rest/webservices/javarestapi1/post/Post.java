package com.kd1987.rest.webservices.javarestapi1.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.kd1987.rest.webservices.javarestapi1.user.*;
import jakarta.validation.constraints.Size;

@Entity(name = "users_posts")
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
