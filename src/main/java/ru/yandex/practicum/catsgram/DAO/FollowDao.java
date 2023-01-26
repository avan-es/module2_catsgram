package ru.yandex.practicum.catsgram.DAO;

import ru.yandex.practicum.catsgram.model.Post;

import java.util.List;

public interface FollowDao {
    List<Post> getFollowFeed(String userId, int max);
}
