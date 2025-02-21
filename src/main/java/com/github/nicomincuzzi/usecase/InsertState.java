package com.github.nicomincuzzi.usecase;

import com.github.nicomincuzzi.domain.MazeMap;
import com.github.nicomincuzzi.domain.MazeRetroRoute;
import com.github.nicomincuzzi.domain.Navigation;
import com.github.nicomincuzzi.domain.Room;
import com.github.nicomincuzzi.domain.Utensils;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InsertState implements MazeState<MazeRetroRoute> {
    private MazeRetroRoute maze;
    private final MazeMap mazeMap;
    private final Scanner scanner;

    public InsertState(Scanner scanner, MazeMap mazeMap) {
        this.mazeMap = mazeMap;
        this.scanner = scanner;
    }

    @Override
    public void enter(MazeRetroRoute maze) {
        this.maze = maze;
    }

    @Override
    public void update() {
        System.out.println("Input start room ID: ");
        int roomNumber = parseInt(scanner.nextLine());

        Room roomMaze = mazeMap.getRooms().getRoomById(roomNumber);

        if (roomMaze == null) {
            System.out.println("Please insert a valid room number!");
            maze.changeStateMazeFsm(new LeaveState());
            return;
        }

        System.out.println("Input objects to collect: ");
        String objToCollect = scanner.nextLine();

        maze.changeStateMazeFsm(new PlayState(new Navigation(mazeMap), new Utensils(objToCollect), roomMaze));
    }
}
