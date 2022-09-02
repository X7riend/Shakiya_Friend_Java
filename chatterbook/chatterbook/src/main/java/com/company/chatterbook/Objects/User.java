package com.company.chatterbook.Objects;

import com.company.chatterbook.Objects.ChatterPost;

import java.util.ArrayList;
import java.util.List;

public class User {
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

    private String name;


    private List <ChatterPost> chatterPosts;
}
