package ru.yandex.practicum.catsgram.exeption;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final String message) {
        super(message);
    }
}