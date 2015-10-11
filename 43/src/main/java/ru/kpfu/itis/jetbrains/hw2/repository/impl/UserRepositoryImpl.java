package ru.kpfu.itis.jetbrains.hw2.repository.impl;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.jetbrains.hw2.model.User;
import ru.kpfu.itis.jetbrains.hw2.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 11.10.2015.
 */

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
