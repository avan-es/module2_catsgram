package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exeption.InvalidEmailException;
import ru.yandex.practicum.catsgram.exeption.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    //private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public Collection<User> findAllUsers() {
        //log.debug("Текущее количество пользоваттелей: {}", users.size());
        return userService.findAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
            return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
