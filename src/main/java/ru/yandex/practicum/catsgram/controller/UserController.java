package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exeption.InvalidEmailException;
import ru.yandex.practicum.catsgram.exeption.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    //private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final HashMap<String, User> users = new HashMap<>();


    @GetMapping
    public Collection<User> findAllUsers() {
        //log.debug("Текущее количество пользоваттелей: {}", users.size());
        return users.values();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
            if (user.getEmail() == null ||
                    user.getEmail().isBlank()) {
                throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
            }
            if (users.containsKey(user.getEmail())) {
                throw new UserAlreadyExistException("Пользователь с электронной почтой " +
                        user.getEmail() + " уже зарегистрирован.");
            }
                //log.debug("Пользователь {} добавлен!", user);
                users.put(user.getEmail(), user);
            return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        if (user.getEmail() == null ||
                user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        users.put(user.getEmail(), user);
        return user;
    }
}
