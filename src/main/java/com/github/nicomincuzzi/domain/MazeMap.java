package com.github.nicomincuzzi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class MazeMap {

    private static final Logger logger = LoggerFactory.getLogger(MazeMap.class);

    @JsonProperty
    private Rooms rooms;

    public MazeMap(Rooms rooms) {
        this.rooms = rooms;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public static MazeMap empty() {
        return new MazeMap(new Rooms());
    }

    public static MazeMap byJsonFile() {
        InputStream input = MazeMap.class.getClassLoader().getResourceAsStream("map.json");
        try {
            return new ObjectMapper().readValue(input, MazeMap.class);
        } catch (Exception e) {
            logger.error("Cannot open file.", e);
        }
        return null;
    }
}
