package com.ubs.opsit.interviews.clock.row.converter.second;

import com.ubs.opsit.interviews.clock.row.converter.RowConverter;
import com.ubs.opsit.interviews.clock.row.provider.second.SecondsRowProvider;
import com.ubs.opsit.interviews.time.Time;

public class SecondsConverter extends RowConverter {

    public SecondsConverter(SecondsRowProvider clockRowProvider) {
        super(clockRowProvider);
    }

    @Override
    protected int calculateNumberOfTurnedOnLamps(Time time) {
        int seconds = time.getSecond();
        //lamp turns on for every even second, therefore '++'
        return ++seconds % 2;
    }
}
