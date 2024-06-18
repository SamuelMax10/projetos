package com.workshopmongo.demo.resource;

import com.workshopmongo.demo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity <List<User>> findaAll() {
        User samuel = new User("1", "Samuel Max", "samuel@gmail.com");
        User sabrina = new User("2", "Sabrina Izabela", "sabrina@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(samuel, sabrina));
        return ResponseEntity.ok().body(list);
    }
}
