package com.couchdb.demo.controller;

import com.couchdb.demo.model.User;
import com.couchdb.demo.service.CouchDbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CouchDbService couchDbService;

    public UserController(CouchDbService couchDbService) {
        this.couchDbService = couchDbService;
    }

    // CREATE
    @PostMapping
    public void createUser(@RequestBody User user) {
        couchDbService.saveUser(user);
    }

    // READ - todos
    @GetMapping
    public List<User> getAllUsers() {
        return couchDbService.findAllUsers();
    }

    // READ - por id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return couchDbService.findUserById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id); // garante que o ID seja mantido
        couchDbService.updateUser(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        couchDbService.deleteUser(id);
    }
}
