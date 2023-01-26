package ru.yandex.practicum.catsgram.model;

import java.util.Objects;

public class Follow {
    private String authorId;
    private String followerId;

    public Follow(String authorId, String followerId) {
        this.authorId = authorId;
        this.followerId = followerId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(authorId, follow.authorId) && Objects.equals(followerId, follow.followerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, followerId);
    }
}
