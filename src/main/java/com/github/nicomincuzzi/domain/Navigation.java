package com.github.nicomincuzzi.domain;

import com.github.nicomincuzzi.maze.Room;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Navigation {

    private final LinkedHashMap<String, GameResult> outputMaze;
    private final List<String> findingItems;
    private final MazeMap mazeMap;

    public Navigation(List<String> findingItems, MazeMap mazeMap) {
        this.findingItems = findingItems;
        this.mazeMap = mazeMap;

        outputMaze = new LinkedHashMap<>();
    }

    public Map<String, GameResult> searchItemsMaze(Room roomMaze) {
        if (roomMaze != null) {
            List<String> foundItems = roomMaze.searchItemsMaze(findingItems);

            GameResult gameResult = new GameResult(roomMaze.getId(), roomMaze.getName(), foundItems);
            outputMaze.put(UUID.randomUUID().toString(), gameResult);

            mazeNavigation(roomMaze);
        }
        return outputMaze;
    }

    private void mazeNavigation(Room roomMaze) {
        Room room = mazeMap.getRooms().getRoomById(roomMaze.getId());

        if (roomMaze.getNorth() != null) {
            int nextRoom = roomMaze.getNorth();
            room.setNorth(null);
            moveNextRoom(nextRoom);
        }

        if (roomMaze.getSouth() != null) {
            int nextRoom = roomMaze.getSouth();
            room.setSouth(null);
            moveNextRoom(nextRoom);
        }

        if (roomMaze.getWest() != null) {
            int nextRoom = roomMaze.getWest();
            room.setWest(null);
            moveNextRoom(nextRoom);
        }

        if (roomMaze.getEast() != null) {
            int nextRoom = roomMaze.getEast();
            room.setEast(null);
            moveNextRoom(nextRoom);
        }
    }

    private void moveNextRoom(int idNextRoom) {
        Room room = mazeMap.getRooms().getRoomById(idNextRoom);
        searchItemsMaze(room);
    }
}
