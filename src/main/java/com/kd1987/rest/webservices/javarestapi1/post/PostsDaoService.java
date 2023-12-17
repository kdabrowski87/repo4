package com.kd1987.rest.webservices.javarestapi1.post;

import com.kd1987.rest.webservices.javarestapi1.post.Post;
import com.kd1987.rest.webservices.javarestapi1.post.PostRepository;
import com.kd1987.rest.webservices.javarestapi1.user.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostsDaoService {

    private PostRepository postRepository;

    public PostsDaoService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Optional<User> givenUser , Post givenPost) {
        givenPost.setUser(givenUser.get());

        Post savedPost = postRepository.save(givenPost);

        return savedPost;
    }

}
