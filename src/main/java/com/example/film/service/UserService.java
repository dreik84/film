package com.example.film.service;

import com.example.film.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final Set<Long> friends;

    public UserService() {
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

    public Set<Long> getFriends() {
        return friends;
    }
}
