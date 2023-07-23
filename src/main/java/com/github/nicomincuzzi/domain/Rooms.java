package com.github.nicomincuzzi.domain;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
    private final List<Room> rooms;

    public Rooms(Room... rooms) {
        this.rooms = new ArrayList<>(List.of(rooms));
    }

    public Room getRoomById(int roomId) {
        return rooms.stream().filter(it -> it.getId() == roomId).
                findFirst()
                .orElse(null);
    }
}
