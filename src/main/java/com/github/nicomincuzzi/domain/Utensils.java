package com.github.nicomincuzzi.domain;

import java.util.ArrayList;
import java.util.List;

public class Utensils {
    private List<Utensil> utensils;

    public Utensils(Utensil... utensils) {
        this.utensils = new ArrayList<>(List.of(utensils));
    }
}
