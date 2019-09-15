package com.twitter;

import com.twitter.service.filebased.ProcessImpl;

public class Main {

    public static void main(String[] args) {
        ProcessImpl process = new ProcessImpl();

        process.loadUsers();
        process.displayFeed();

    }
}
