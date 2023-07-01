package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.maze.Room;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
    List<Room> rooms;

    public Rooms(Room... rooms) {
        this.rooms = new ArrayList<>(List.of(rooms));
    }

    public Room getRoomById(int roomId) {
        return rooms.stream().filter(it -> it.getId() == roomId).
                findFirst()
                .orElse(null);
    }
}
