package com.workshopmongo.demo.dto;

import com.workshopmongo.demo.domain.User;

public class AuthorDto {

    private String id;

    private String name;

    public AuthorDto(){

    }

    public AuthorDto(User user){

        id = user.getId();

        name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
