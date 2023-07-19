package com.github.nicomincuzzi.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class Utensils {
    private List<Utensil> utensils = new ArrayList<>();

    public List<Utensil> getUtensils() {
        return utensils;
    }

    public Utensils(List<Utensil> utensils) {
        this.utensils = utensils;
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

    public Utensils matchedItems(Utensils objects) {
        List<Utensil> matchedItems = new ArrayList<>();
        for (Utensil item : utensils) {
            objects.getUtensils().stream()
                    .filter(it -> it.isSameThan(item.getName()))
                    .findFirst()
                    .ifPresent(it -> matchedItems.add(new Utensil(it.getName())));
        }
        return new Utensils(matchedItems);
    }
}
