package com.twitter.service;

import com.twitter.domain.user.User;

import java.util.HashMap;

public interface Process {

    HashMap<String, User> loadUsers();
}
