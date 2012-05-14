package com.cecapstone.pda;

public interface JoystickMovedListener {

    void OnMoved(int userX, int userY);

    void OnReleased();

    void OnReturnedToCenter();

}
