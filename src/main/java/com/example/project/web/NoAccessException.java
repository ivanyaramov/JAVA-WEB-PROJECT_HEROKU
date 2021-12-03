package com.example.project.web;

public class NoAccessException extends RuntimeException{



    public NoAccessException() {
        super("You do no have access to view this page!");

    }

}
