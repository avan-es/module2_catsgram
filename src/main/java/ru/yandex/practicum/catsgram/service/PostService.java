package ru.yandex.practicum.catsgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exeption.InvalidEmailException;
import ru.yandex.practicum.catsgram.exeption.PostNotFoundException;
import ru.yandex.practicum.catsgram.exeption.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final UserService userService;
    private Integer postId = 0;
    @Autowired
    public PostService(UserService userServiceIn) {
        this.userService = userServiceIn;
    }

    public List<Post> findAll(String sort, Integer size, Integer from) {
        return posts.stream().sorted((p0, p1) -> {
            int comp = p0.getCreationDate().compareTo(p1.getCreationDate());
            if (sort.equals("desc")) {
                comp = -1 * comp;
            }
            return comp;
        }).skip(from).limit(size).collect(Collectors.toList());
    }

    public Post create(Post post) {
        if (userService.findUserByEmail(post.getAuthor()) != null){
            post.setPostId(postId++);
            posts.add(post);
            return post;
        }
        throw new UserNotFoundException(String.format("Пользователь %s не найден",
                post.getAuthor()));
    }

    public Post findPostById(Integer postId) {
        return posts.stream()
                .filter(p -> p.getPostId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException(String.format("Пост № %d не найден.", postId)));
    }
}