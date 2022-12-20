package ru.yandex.practicum.catsgram.exeption;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(final String message) {
        super(message);
    }
}