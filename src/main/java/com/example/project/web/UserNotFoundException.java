package com.example.project.web;

public class UserNotFoundException extends RuntimeException{

    private final String username;
    private final String type;

    public UserNotFoundException(String username, String type) {
        super("Object with username " + username + " not found in " + type);
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }
}