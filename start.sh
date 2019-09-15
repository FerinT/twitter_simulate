#!/usr/bin/env bash

mvn compile
mvn exec:java -D"exec.mainClass"="com.twitter.Main"