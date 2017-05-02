package com.ubs.opsit.interviews.clock.row.converter.minute;

import com.ubs.opsit.interviews.clock.row.converter.RowConverter;
import com.ubs.opsit.interviews.clock.row.provider.minute.TopMinutesRowProvider;
import com.ubs.opsit.interviews.time.Time;

public class TopRowMinutesConverter extends RowConverter {

    public TopRowMinutesConverter(TopMinutesRowProvider clockRowProvider) {
        super(clockRowProvider);
    }

    @Override
    protected int calculateNumberOfTurnedOnLamps(Time time) {
        return time.getMinute() / 5;
    }
}
