package com.github.nicomincuzzi.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.nicomincuzzi.domain.MazeMap;
import com.github.nicomincuzzi.domain.Room;
import com.github.nicomincuzzi.domain.Rooms;
import com.github.nicomincuzzi.domain.Utensil;
import com.github.nicomincuzzi.domain.Utensils;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MazeMapJson {
    @JsonProperty
    private List<RoomJson> rooms;

    public MazeMap toMazeMap() {
        Room[] rooms = new Room[this.rooms.size()];

        for (int i = 0; i < this.rooms.size(); i++) {
            MazeMapJson.RoomJson room = this.rooms.get(i);
            List<Utensil> utensils = room.getObjects().stream()
                    .map(it -> new Utensil(it.getName()))
                    .collect(toList());

            rooms[i] = new Room(room.getId(), room.getName(), room.getNorth(), room.getSouth(), room.getEast(), room.getWest(), new Utensils(utensils));
        }
        return new MazeMap(new Rooms(rooms));
    }

    public static class RoomJson {
        @JsonProperty
        private int id;
        @JsonProperty
        private String name;
        @JsonProperty
        private Integer north;
        @JsonProperty
        private Integer south;
        @JsonProperty
        private Integer east;
        @JsonProperty
        private Integer west;
        @JsonProperty
        private List<UtensilJson> objects;

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

        public List<UtensilJson> getObjects() {
            return objects;
        }
    }

    public static class UtensilJson {
        @JsonProperty
        private String name;

        public String getName() {
            return name;
        }
    }
}
