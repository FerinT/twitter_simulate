package com.twitter.domain.tweet;

import com.twitter.domain.user.User;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * Domain class for a single tweet
 *
 **/

public class Tweet {
    private HashMap<String, User> retweets;
    private String tweet;

    public HashMap<String, User> getRetweets() {
        return retweets;
    }

    public void setRetweets(HashMap<String, User> retweets) {
        this.retweets = retweets;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet)) return false;
        Tweet tweet1 = (Tweet) o;
        return Objects.equals(getRetweets(), tweet1.getRetweets()) &&
                Objects.equals(getTweet(), tweet1.getTweet());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRetweets(), getTweet());
    }
}
