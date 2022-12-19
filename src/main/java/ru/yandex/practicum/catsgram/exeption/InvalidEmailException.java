package ru.yandex.practicum.catsgram.exeption;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(final String message) {
        super(message);
    }
}
