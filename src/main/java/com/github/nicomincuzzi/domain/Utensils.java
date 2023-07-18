package com.github.nicomincuzzi.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class Utensils {
    private List<Utensil> utensils = new ArrayList<>();

    public Utensils(Utensil... utensils) {
        this.utensils = new ArrayList<>(List.of(utensils));
    }

    public Utensils(String listWords) {
        stream(listWords.split(",")).forEach(it -> {
            Utensil utensil = new Utensil(it.trim());
            utensils.add(utensil);
        });
    }

    public int size() {
        return utensils.size();
    }

    public List<String> matchedItems(List<Utensil> objects) {
        List<String> foundItems = new ArrayList<>();
        for (Utensil item : utensils) {
            objects.stream()
                    .filter(it -> it.isSameThan(item.getName()))
                    .findFirst()
                    .ifPresent(it -> foundItems.add(it.getName()));
        }
        return foundItems;
    }
}
