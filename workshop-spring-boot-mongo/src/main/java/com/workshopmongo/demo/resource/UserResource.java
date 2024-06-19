package com.workshopmongo.demo.resource;

import com.workshopmongo.demo.domain.User;
import com.workshopmongo.demo.dto.UserDto;
import com.workshopmongo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findaAll() {
        List<User> list = service.findAll();
        List<UserDto> dtoList = list.stream().map(UserDto::new).collect(Collectors.toList()); /*Convertendo uma lista de User para uma lista UserDto.*/
        return ResponseEntity.ok().body(dtoList);
    }
}
