package ru.kpfu.itis.jetbrains.hw2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.jetbrains.hw2.model.User;
import ru.kpfu.itis.jetbrains.hw2.repository.UserRepository;
import ru.kpfu.itis.jetbrains.hw2.service.UserService;

import java.util.List;

/**
 * Created by Vladislav on 11.10.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository rep;

    @Override
    public List<User> getAllUsers() {
        return rep.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        if (user.getBirthday().isEmpty()) {
            user.setBirthday("Не указано");
        }
        if (user.getSex() == null) {
            user.setSex("Не указано");
        }
        rep.addUser(user);
    }
}
