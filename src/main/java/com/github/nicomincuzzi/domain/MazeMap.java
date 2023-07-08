package com.github.nicomincuzzi.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nicomincuzzi.infrastructure.MazeMapJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class MazeMap {

    private static final Logger logger = LoggerFactory.getLogger(MazeMap.class);

    private Rooms rooms;

    public MazeMap() {
    }

    public MazeMap(Rooms rooms) {
        this.rooms = rooms;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public static MazeMap byJsonFile() {
        InputStream input = MazeMap.class.getClassLoader().getResourceAsStream("map.json");
        try {
            MazeMapJson mazeMapJson = new ObjectMapper().readValue(input, MazeMapJson.class);
            return mazeMapJson.toMazeMap();
        } catch (Exception e) {
            logger.error("Cannot open file.", e);
        }
        return null;
    }
}
