package com.twitter.tweet;

import com.twitter.user.User;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * Domain class for a single tweet
 *
 * */

public class Tweet {
    private int likes;
    private HashMap<Integer, User> retweets;
    private String tweet;
    private User user;
    private long id;


    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public HashMap<Integer, User> getRetweets() {
        return retweets;
    }

    public void setRetweets(HashMap<Integer, User> retweets) {
        this.retweets = retweets;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet)) return false;
        Tweet tweet1 = (Tweet) o;
        return likes == tweet1.likes &&
                id == tweet1.id &&
                Objects.equals(retweets, tweet1.retweets) &&
                Objects.equals(tweet, tweet1.tweet) &&
                Objects.equals(user, tweet1.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(likes, retweets, tweet, user, id);
    }
}
