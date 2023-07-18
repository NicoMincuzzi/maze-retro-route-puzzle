package com.github.nicomincuzzi.utils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class StringHandler {

    private static StringHandler instance;

    private StringHandler() {
    }

    public static synchronized StringHandler getInstance() {
        if (instance == null) {
            instance = new StringHandler();
        }
        return instance;
    }

    public List<String> getListInputWords(String listWords) {
        return stream(listWords.split(",")).map(String::trim).collect(Collectors.toList());
    }
}
