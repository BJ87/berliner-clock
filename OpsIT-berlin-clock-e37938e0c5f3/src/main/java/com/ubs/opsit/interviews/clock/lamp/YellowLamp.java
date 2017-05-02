package com.ubs.opsit.interviews.clock.lamp;

public class YellowLamp extends Lamp {
    @Override
    public void turnOn() {
        this.state = "Y";
    }
}
