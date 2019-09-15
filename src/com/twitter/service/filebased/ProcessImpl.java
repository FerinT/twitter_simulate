package com.twitter.service.filebased;

import com.twitter.service.Process;
import com.twitter.domain.tweet.Tweet;
import com.twitter.domain.user.User;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ProcessImpl implements Process {

    private final String UTILSPATH = "src/com/twitter/utils/";
    private HashMap<String, User> users = new HashMap<>();

    @Override
    public HashMap<String, User> loadUsers() {
        try {
            Files.lines(Paths.get(UTILSPATH + "user.txt"), StandardCharsets.UTF_8).forEach((line) -> {

                line = line.replace(",", "");
                line = line.replace("follows ", "");

                String[] result = line.split(" ");

                User firstUser = new User();
                for (int i = 0; i < result.length; i++) {
                    User user = users.get(result[i]);
                    if (user == null) {
                        user = new User();
                        user.setUsername(result[i]);
                    }
                    if (i == 0) {
                        firstUser = user;
                        users.put(firstUser.getUsername(), firstUser);
                    } else {
                        users.put(user.getUsername(), user);
                        firstUser.setFollowing(user);
                    }
                }

            });
            loadTweets();
        } catch (Exception e) {
            System.out.println("Error loading users: " + e);

        }
        return users;
    }

    public void displayFeed(){
        users.forEach((username,user) -> {
            System.out.println(username);
            user.getFollowing().forEach((key, value) -> {
                for(Tweet tweet: value.getTweets()){
                    System.out.println("    @" + key + " " + tweet.getTweet());
                }

            });
            for(Tweet tweet: user.getTweets()){
                System.out.println("    @" + username + " " + tweet.getTweet());
            }
        });
    }

    private void loadTweets() {
        try {
            Files.lines(Paths.get(UTILSPATH + "tweet.txt"), StandardCharsets.UTF_8).forEach((line) -> {
                String[] result = line.split("> ");

                User user = users.get(result[0]);

                if (user != null) {
                    Tweet tweet = new Tweet();
                    tweet.setTweet(result[1]);

                    user.setTweets(tweet);
                }

            });

        } catch (Exception e) {
            System.out.println("Error loading tweets: " + e);
        }
    }
}
