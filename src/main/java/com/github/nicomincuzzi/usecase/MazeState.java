package com.github.nicomincuzzi.usecase;

public interface MazeState<T> {
    void enter(T maze);

    void execute();

    default void exit() {
    }
}
