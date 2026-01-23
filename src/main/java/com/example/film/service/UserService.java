package com.example.film.service;

import com.example.film.model.User;
import com.example.film.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final Set<Long> friends;
    private final UserStorage storage;

    @Autowired
    public UserService(UserStorage storage) {
        this.storage = storage;
        friends = new HashSet<>();
    }

    public User addToFriends(User user) {
        friends.add(user.getId());
        return user;
    }

    public User deleteFromFriends(User user) {
        friends.remove(user.getId());
        return user;
    }

    public Set<Long> getCommonFriends(User user) {
        return friends;
    }

    public Set<Long> getFriends() {
        return friends;
    }
}
