package com.kd1987.rest.webservices.javarestapi1.post;

import com.kd1987.rest.webservices.javarestapi1.user.User;
import com.kd1987.rest.webservices.javarestapi1.user.UserDaoService;
import com.kd1987.rest.webservices.javarestapi1.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

 private PostsDaoService postsDaoService;
 private UserDaoService userDaoService;

    public PostController(PostsDaoService postsDaoService, UserDaoService userDaoService) {
        this.postsDaoService = postsDaoService;
        this.userDaoService = userDaoService;
    }

    @GetMapping("users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {

        Optional<User> searched = userDaoService.findById(id);

        if(searched.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }

        return searched.get().getPosts();

    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {

        Optional<User> searchedUser = userDaoService.findById(id);

        if(searchedUser.isEmpty()) {
            throw new UserNotFoundException("id: "+ id);
        }

        Post savedPost = postsDaoService.save(searchedUser,post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").
                buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
