package com.twitter.user;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * User domain class
 *
 * */
public class User {

    private String username;
    private HashMap<Integer, User> followers;
    private HashMap<Integer, User> following = new HashMap<>();
    // add an array of tweets per user??

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<Integer, User> getFollowers() {
        return followers;
    }

    public void setFollowers(User user) {
        this.followers.put(user.hashCode(), user);
    }

    public HashMap<Integer, User> getFollowing() {
        return following;
    }

    public void setFollowing(User user) {
        this.following.put(user.hashCode(),user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getFollowers(), user.getFollowers()) &&
                Objects.equals(getFollowing(), user.getFollowing());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUsername(), getFollowers(), getFollowing());
    }
}
