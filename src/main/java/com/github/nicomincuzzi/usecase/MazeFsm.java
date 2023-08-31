package com.github.nicomincuzzi.usecase;

public class MazeFsm<T> {

    private MazeState<T> currentState;
    private MazeState<T> previousState;

    //Represent the Finite State Machine
    private T owner;

    public void startBy(T o, MazeState<T> initialState) {
        owner = o;
        changeState(initialState);
    }

    public void changeState(MazeState<T> newState) {
        previousState = currentState;
        if (previousState != null)
            previousState.exit();

        currentState = newState;

        currentState.enter(owner);

        if (currentState != null)
            currentState.update();
    }

    public void revertToPreviousState() {
        if (previousState != null)
            changeState(previousState);
    }
}
