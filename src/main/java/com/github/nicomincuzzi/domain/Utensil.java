package com.github.nicomincuzzi.domain;

public class Utensil {

    private final String name;

    public Utensil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameThan(String item) {
        return item.equalsIgnoreCase(name);
    }
}
