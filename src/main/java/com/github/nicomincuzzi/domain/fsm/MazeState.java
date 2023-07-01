package com.github.nicomincuzzi.domain.fsm;

public interface MazeState<T> {
    void enter(T maze);

    void execute();

    default void exit() {
    }
}
