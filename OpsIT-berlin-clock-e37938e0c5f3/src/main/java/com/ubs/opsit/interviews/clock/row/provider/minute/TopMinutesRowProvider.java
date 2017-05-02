package com.ubs.opsit.interviews.clock.row.provider.minute;

import com.ubs.opsit.interviews.clock.lamp.Lamp;
import com.ubs.opsit.interviews.clock.lamp.RedLamp;
import com.ubs.opsit.interviews.clock.lamp.YellowLamp;
import com.ubs.opsit.interviews.clock.row.ClockRow;
import com.ubs.opsit.interviews.clock.row.provider.ClockRowProvider;

import java.util.ArrayList;
import java.util.List;

public class TopMinutesRowProvider implements ClockRowProvider {

    private static final int LAMPS_NUMBER_IN_TOP_MINUTES_ROW = 11;
    private static final int RED_LAMP_INDEX = 3;

    @Override
    public ClockRow create() {
        List<Lamp> lamps = new ArrayList<>();
        for (int i = 1; i <= LAMPS_NUMBER_IN_TOP_MINUTES_ROW; i++) {
            lamps.add(createLamp(i));
        }
        return new ClockRow(lamps);
    }

    private Lamp createLamp(int i) {
        return isRedLamp(i) ? new RedLamp() : new YellowLamp();
    }

    private boolean isRedLamp(int index) {
        return index % RED_LAMP_INDEX == 0;
    }
}
