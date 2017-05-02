package com.ubs.opsit.interviews.clock.row.converter.hour;

import com.ubs.opsit.interviews.clock.row.converter.RowConverter;
import com.ubs.opsit.interviews.clock.row.provider.hour.HourRowProvider;
import com.ubs.opsit.interviews.time.Time;

public class BottomRowHoursConverter extends RowConverter {

    public BottomRowHoursConverter(HourRowProvider clockRowProvider) {
        super(clockRowProvider);
    }

    @Override
    protected int calculateNumberOfTurnedOnLamps(Time time) {
        return time.getHour() % 5;
    }
}
