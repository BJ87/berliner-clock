package com.ubs.opsit.interviews.clock.lamp;

public class RedLamp extends Lamp {
    @Override
    public void turnOn() {
        this.state = "R";
    }
}
