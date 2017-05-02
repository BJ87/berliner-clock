package com.ubs.opsit.interviews.clock.row.converter.hour;

import com.ubs.opsit.interviews.clock.row.converter.RowConverter;
import com.ubs.opsit.interviews.clock.row.provider.hour.HourRowProvider;
import com.ubs.opsit.interviews.time.Time;

public class TopRowHoursConverter extends RowConverter {

    public TopRowHoursConverter(HourRowProvider clockRowProvider) {
        super(clockRowProvider);
    }

    @Override
    protected int calculateNumberOfTurnedOnLamps(Time time) {
        return time.getHour() / 5;
    }
}
