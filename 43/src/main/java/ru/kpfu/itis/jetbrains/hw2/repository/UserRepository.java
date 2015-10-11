package ru.kpfu.itis.jetbrains.hw2.repository;

import ru.kpfu.itis.jetbrains.hw2.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 11.10.2015.
 */
public interface UserRepository {
    List<User> getAllUsers();
    void addUser(String firstName, String lastName, String middleName, String birthday, String sex);
}
