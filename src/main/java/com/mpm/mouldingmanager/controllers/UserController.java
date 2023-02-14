package com.mpm.mouldingmanager.controllers;

import com.mpm.mouldingmanager.entities.Mould;
import com.mpm.mouldingmanager.entities.User;
import com.mpm.mouldingmanager.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // CREATE USER

    /**
     * Create a new user
     * @param newUser need a body to add to repository
     * @return a new user
     */
    @PostMapping("/users")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        if (newUser.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        User result = repository.save(newUser);
        return ResponseEntity.ok(result);
    }

    // SEARCH USERS

    /**
     * Find all users of the repository
     * @return User list
     */
    @GetMapping("/users")
    List<User> allUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    User searchIdUser(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new Error("No existe este usuario"));
    }

    // UPDATE USER

    /**
     * Update user details.
     * @param newUser with a body
     * @param id
     * @return the edited user
     */
    @PutMapping("/users/{id}")
    User editUser(@RequestBody User newUser, @PathVariable Long id) {
        // Clones the user, then changes data and save it.
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setRole(newUser.getRole());
                    return repository.save(newUser);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    // DELETE USERS

    /**
     * Delete all users
     */
    @DeleteMapping("/users")
    void deleteAll() {
        repository.deleteAll();
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
