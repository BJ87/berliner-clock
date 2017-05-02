package com.ubs.opsit.interviews.clock.lamp;

public abstract class Lamp {
    protected String state = "O";

    public String getState() {
        return state;
    }

    public abstract void turnOn();
}
