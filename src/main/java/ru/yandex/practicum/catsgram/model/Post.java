package ru.yandex.practicum.catsgram.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private Integer id; // ID поста
    private final User author; // автор
    private final LocalDate creationDate;// = Instant.now(); // дата создания
    private String description; // описание
    private String photoUrl; // url-адрес фотографии


    public Post(User author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
        this.creationDate = LocalDate.now();
    }

    public Post(Integer id, User author, String description, String photoUrl, LocalDate creationDate) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(author, post.author) && Objects.equals(creationDate, post.creationDate) && Objects.equals(description, post.description) && Objects.equals(photoUrl, post.photoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, creationDate, description, photoUrl);
    }
}