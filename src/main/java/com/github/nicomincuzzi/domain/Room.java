package com.github.nicomincuzzi.domain;

import java.util.List;

public class Room {

    private final int id;
    private final String name;
    private Integer north;
    private Integer south;
    private Integer east;
    private Integer west;
    private final Utensils utensils;

    public Room(int id,
                String name,
                Integer north,
                Integer south,
                Integer east,
                Integer west,
                Utensils utensils
    ) {
        this.id = id;
        this.name = name;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.utensils = utensils;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNorth() {
        return north;
    }

    public Integer getSouth() {
        return south;
    }

    public Integer getEast() {
        return east;
    }

    public Integer getWest() {
        return west;
    }

    public void setNorth(Integer north) {
        this.north = north;
    }

    public void setSouth(Integer south) {
        this.south = south;
    }

    public void setEast(Integer east) {
        this.east = east;
    }

    public void setWest(Integer west) {
        this.west = west;
    }

    public Utensils searchItemsMaze(Utensils findingItems) {
        return utensils.matchedItems(findingItems);
    }
}
