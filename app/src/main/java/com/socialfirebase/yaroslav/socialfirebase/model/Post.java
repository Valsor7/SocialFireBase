package com.socialfirebase.yaroslav.socialfirebase.model;

/**
 * Created by yaroslav on 12.10.16.
 */

public class Post {
    String postId;
    String url;
    String title;
    String owner;

    public Post() {
    }

    public Post(String postId, String url, String title, String owner) {
        this.postId = postId;
        this.url = url;
        this.title = title;
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public String getOwner() {
        return owner;
    }

    public String getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
