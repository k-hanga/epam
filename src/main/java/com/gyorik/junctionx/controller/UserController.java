package com.gyorik.junctionx.controller;

import com.gyorik.junctionx.domain.User;
import com.gyorik.junctionx.exception.UserNotFoundException;
import com.gyorik.junctionx.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    /*@GetMapping
    public List<User> getAll(@RequestParam(required = false, defaultValue = "") String keyword) {
        return keyword.equals("") ? userRepository.findAll() : userRepository.findByKeyword(keyword);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable long id) {
        User user = userRepository.findById(id);
        if (user == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(user);
    }

    @PostMapping
    public User create(@RequestBody User note) {
        note.setId(null);
        return userRepository.save(note);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User note) {
        User n = userRepository.findById(note.getId());
        if (n == null)
            return ResponseEntity.notFound().build();
        n = userRepository.save(note);
        return ResponseEntity.ok(n);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        User note = userRepository.findById(id);
        if (note == null)
            return ResponseEntity.notFound().build();
        else {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }*/



    // Aggregate root
    // tag::get-aggregate-root[]
    @CrossOrigin
    @GetMapping("/api/users")
    List<User> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @CrossOrigin
    @PostMapping("/api/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @CrossOrigin
    @GetMapping("/api/users/{id}")
    User one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @CrossOrigin
    @PutMapping("/api/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.CopyUser(newUser);
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @CrossOrigin
    @DeleteMapping("/api/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
