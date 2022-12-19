package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exeption.InvalidEmailException;
import ru.yandex.practicum.catsgram.exeption.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();


    public Collection<User> findAllUsers() {
        return users.values();
    }

    public User createUser(User user) {
        if (user.getEmail() == null ||
                user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователь с электронной почтой " +
                    user.getEmail() + " уже зарегистрирован.");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User updateUser(User user) {
        if (user.getEmail() == null ||
                user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User findUserByEmail(String email){
        if (users.containsKey(email)) {
            return users.get(email);
        }
        return null;
    }
}