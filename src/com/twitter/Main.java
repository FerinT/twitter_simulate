package com.twitter;

import com.twitter.service.file.ProcessImpl;

public class Main {

    public static void main(String[] args) {
        ProcessImpl process = new ProcessImpl();

        process.loadUser();
    }
}
