package com.github.nicomincuzzi.domain;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
    List<Room> rooms;

    public Rooms() {
    }

    public Rooms(Room... rooms) {
        this.rooms = new ArrayList<>(List.of(rooms));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoomById(int roomId) {
        return rooms.stream().filter(it -> it.getId() == roomId).
                findFirst()
                .orElse(null);
    }
}
