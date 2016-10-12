package com.socialfirebase.yaroslav.socialfirebase.model;

/**
 * Created by yaroslav on 10.10.16.
 */

public class User {
    public String username;
    public String email;

    public User() {
    }

    public User(String username, String email) {

        this.username = username;
        this.email = email;
    }

    public String getUsername() {

        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
