package com.ubs.opsit.interviews.clock.row.provider.second;

import com.ubs.opsit.interviews.clock.lamp.Lamp;
import com.ubs.opsit.interviews.clock.lamp.YellowLamp;
import com.ubs.opsit.interviews.clock.row.ClockRow;
import com.ubs.opsit.interviews.clock.row.provider.ClockRowProvider;

import java.util.ArrayList;
import java.util.List;

public class SecondsRowProvider implements ClockRowProvider {
    @Override
    public ClockRow create() {
        List<Lamp> lamps = new ArrayList<>();
        lamps.add(new YellowLamp());
        return new ClockRow(lamps);
    }
}
