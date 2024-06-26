package com.workshopmongo.demo.service;

import com.workshopmongo.demo.domain.User;
import com.workshopmongo.demo.dto.UserDto;
import com.workshopmongo.demo.repository.UserRepository;
import com.workshopmongo.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return repository.save(newUser);
    }

    public void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDto(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

}
