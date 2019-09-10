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
    private long id;
    private HashMap<Integer, User> followers;
    private HashMap<Integer, User> following;
    // add an array of tweets per user??

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashMap<Integer, User> getFollowers() {
        return followers;
    }

    public void setFollowers(HashMap<Integer, User> followers) {
        this.followers = followers;
    }

    public HashMap<Integer, User> getFollowing() {
        return following;
    }

    public void setFollowing(HashMap<Integer, User> following) {
        this.following = following;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, id);
    }
}
