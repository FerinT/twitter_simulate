package com.twitter.service;

import com.twitter.tweet.Tweet;
import com.twitter.user.User;

import java.util.HashMap;

public interface Process {

    HashMap<String, User> loadUser();
    HashMap<Integer, Tweet>  loadTweets();
}
