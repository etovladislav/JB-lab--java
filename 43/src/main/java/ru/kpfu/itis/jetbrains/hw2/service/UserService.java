package ru.kpfu.itis.jetbrains.hw2.service;

import ru.kpfu.itis.jetbrains.hw2.model.User;

import java.util.List;

/**
 * Created by Vladislav on 11.10.2015.
 */
public interface UserService {
        List<User> getAllUsers();
        void addUser(User user);
}
