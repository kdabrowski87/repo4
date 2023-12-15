package com.kd1987.rest.webservices.javarestapi1.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    private UserDaoService userDaoService;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        User searched = userDaoService.findById(id);
        if(searched==null){
            throw new UserNotFoundException("id:"+id);
        }
        return searched;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> crateUser(@RequestBody User user) {
       User saved = userDaoService.save(user);
        // return URI of created user - location heder

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").
                buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDaoService.deleteById(id);
    }
}