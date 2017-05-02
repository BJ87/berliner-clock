package com.ubs.opsit.interviews.clock.row.converter.minute;

import com.ubs.opsit.interviews.clock.row.converter.RowConverter;
import com.ubs.opsit.interviews.clock.row.provider.minute.BottomMinutesRowProvider;
import com.ubs.opsit.interviews.time.Time;

public class BottomRowMinuteConverter extends RowConverter {

    public BottomRowMinuteConverter(BottomMinutesRowProvider clockRowProvider) {
        super(clockRowProvider);
    }

    @Override
    protected int calculateNumberOfTurnedOnLamps(Time time) {
        return time.getMinute() % 5;
    }
}
