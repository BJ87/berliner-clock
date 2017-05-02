package com.ubs.opsit.interviews.clock.row;

import com.ubs.opsit.interviews.clock.lamp.Lamp;

import java.util.List;

public class ClockRow {

    private final List<Lamp> lamps;

    public ClockRow(List<Lamp> lamps) {
        this.lamps = lamps;
    }

    public void turnLampsOn(int lampsToTurnOn) {
        int effectiveLampsToTurnOn = Math.min(lamps.size(), lampsToTurnOn);
        for (int i = 0; i < effectiveLampsToTurnOn; i++) {
            lamps.get(i).turnOn();
        }
    }

    public String retrieveLampConfiguration() {
        StringBuilder configurationBuilder = new StringBuilder();
        for (Lamp lamp : lamps) {
            configurationBuilder.append(lamp.getState());
        }
        return configurationBuilder.toString();
    }
}
