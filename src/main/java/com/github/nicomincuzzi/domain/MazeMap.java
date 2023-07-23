package com.github.nicomincuzzi.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nicomincuzzi.infrastructure.MazeMapJson;

import java.io.InputStream;

public class MazeMap {
    private final Rooms rooms;

    public MazeMap(Rooms rooms) {
        this.rooms = rooms;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public static MazeMap byJsonFile() {
        InputStream input = MazeMap.class.getClassLoader().getResourceAsStream("map.json");
        try {
            MazeMapJson mazeMapJson = new ObjectMapper().readValue(input, MazeMapJson.class);
            return mazeMapJson.toMazeMap();
        } catch (Exception e) {
            throw new RuntimeException("Cannot open file: map.json", e);
        }
    }
}
