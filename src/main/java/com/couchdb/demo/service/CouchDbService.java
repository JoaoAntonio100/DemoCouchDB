package com.couchdb.demo.service;

import com.couchdb.demo.model.User;
import com.couchdb.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouchDbService {

    private final UserRepository userRepository;

    public CouchDbService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public void saveUser(User user) {
        userRepository.add(user);
    }

    // READ - todos
    public List<User> findAllUsers() {
        return userRepository.getAll();
    }

    // READ - por id
    public User findUserById(String id) {
        return userRepository.get(id);
    }

    // UPDATE
    public void updateUser(User user) {
        userRepository.update(user);
    }

    // DELETE
    public void deleteUser(String id) {
        User existingUser = userRepository.get(id);
        if (existingUser != null) {
            userRepository.remove(existingUser);
        }
    }
}

