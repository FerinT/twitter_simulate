package com.twitter.domain.user;

import com.twitter.domain.tweet.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 *
 * User domain class
 *
 **/
public class User {

    private String username;
    private HashMap<String, User> following = new HashMap<>();
    private List<Tweet> tweets = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Tweet tweets) {
        this.tweets.add(tweets);
    }

    public HashMap<String, User> getFollowing() {
        return following;
    }

    public void setFollowing(User user) {
        this.following.put(user.getUsername(),user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getFollowing(), user.getFollowing()) &&
                Objects.equals(getTweets(), user.getTweets());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUsername(), getFollowing(), getTweets());
    }
}
