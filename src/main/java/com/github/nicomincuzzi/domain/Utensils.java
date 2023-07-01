package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.maze.Room;
import com.github.nicomincuzzi.maze.Utensil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Utensils {
    private List<Utensil> utensils;

    public Utensils(Utensil... utensils) {
        this.utensils = new ArrayList<>(List.of(utensils));
    }
}
