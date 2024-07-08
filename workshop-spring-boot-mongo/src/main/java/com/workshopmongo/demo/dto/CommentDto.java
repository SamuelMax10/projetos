package com.workshopmongo.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CommentDto {

    private String text;

    private Date date;

    private AuthorDto author;

    public CommentDto(){

    }

    public CommentDto(String text, Date date, AuthorDto author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}


