package com.twitter.service.file;

import com.twitter.service.Process;
import com.twitter.tweet.Tweet;
import com.twitter.user.User;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class ProcessImpl implements Process {

    private final String UTILSPATH = "src/com/twitter/utils/";
    private HashMap<String, User> users = new HashMap<>();
    HashMap<Integer, Tweet> tweets;

    @Override
    public HashMap<String, User>  loadUser() {
        try {
            Files.lines(Paths.get(UTILSPATH + "user.txt"), StandardCharsets.UTF_8).forEach((line) -> {

                line = line.replace(",", "");
                line = line.replace("follows " , "");

                String[] result = line.split(" ");

                User firstUser = new User();
                for( int i = 0; i < result.length; i++) {
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
        } catch(Exception e) {
            System.out.println("error: " + e);

        }
        return  users;
    }

    @Override
    public HashMap<Integer, Tweet>  loadTweets() {
        return  tweets;
    }
}
