package com.ubs.opsit.interviews.clock.row.provider.minute;

import com.ubs.opsit.interviews.clock.lamp.Lamp;
import com.ubs.opsit.interviews.clock.lamp.YellowLamp;
import com.ubs.opsit.interviews.clock.row.ClockRow;
import com.ubs.opsit.interviews.clock.row.provider.ClockRowProvider;

import java.util.ArrayList;
import java.util.List;

public class BottomMinutesRowProvider implements ClockRowProvider {

    private static final int LAMPS_NO_IN_BOTTOM_MINUTES_ROW = 4;

    @Override
    public ClockRow create() {
        List<Lamp> lamps = new ArrayList<>();
        for (int i = 0; i < LAMPS_NO_IN_BOTTOM_MINUTES_ROW; i++) {
            lamps.add(new YellowLamp());
        }
        return new ClockRow(lamps);
    }
}
