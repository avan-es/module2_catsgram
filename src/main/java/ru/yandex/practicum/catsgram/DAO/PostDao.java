package ru.yandex.practicum.catsgram.DAO;

import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;

public interface PostDao {
    Collection<Post> findPostsByUser(User user);
}
