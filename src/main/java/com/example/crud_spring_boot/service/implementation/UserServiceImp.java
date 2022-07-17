package com.example.crud_spring_boot.service.implementation;

import com.example.crud_spring_boot.model.User;
import com.example.crud_spring_boot.repository.UserRepository;
import com.example.crud_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        this.repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(User user) {
        this.repository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optional = repository.findById(id);
        User user;
        if(optional.isPresent()){
            user = optional.get();
        }else{
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return user;
    }
}
