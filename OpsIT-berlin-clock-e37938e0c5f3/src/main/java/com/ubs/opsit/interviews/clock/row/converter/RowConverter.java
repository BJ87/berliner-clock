package com.ubs.opsit.interviews.clock.row.converter;

import com.ubs.opsit.interviews.clock.row.ClockRow;
import com.ubs.opsit.interviews.clock.row.provider.ClockRowProvider;
import com.ubs.opsit.interviews.time.Time;

public abstract class RowConverter implements TimeUnitConverter {

    private final ClockRowProvider clockRowProvider;

    public RowConverter(ClockRowProvider clockRowProvider) {
        this.clockRowProvider = clockRowProvider;
    }

    @Override
    public String convert(Time time) {
        int turnedOnLamps = calculateNumberOfTurnedOnLamps(time);
        ClockRow clockRow = clockRowProvider.create();
        clockRow.turnLampsOn(turnedOnLamps);
        return clockRow.retrieveLampConfiguration();
    }

    protected abstract int calculateNumberOfTurnedOnLamps(Time time);

}
