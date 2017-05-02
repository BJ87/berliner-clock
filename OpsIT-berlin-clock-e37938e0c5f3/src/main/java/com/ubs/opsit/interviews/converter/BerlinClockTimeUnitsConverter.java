package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.clock.row.converter.TimeUnitConverter;
import com.ubs.opsit.interviews.time.Time;

import java.util.List;

public class BerlinClockTimeUnitsConverter {
    static final String LINE_SEPARATOR = System.lineSeparator();

    private final List<TimeUnitConverter> timeUnitConverters;

    public BerlinClockTimeUnitsConverter(List<TimeUnitConverter> timeUnitConverters) {
        this.timeUnitConverters = timeUnitConverters;
    }

    public String convert(Time time) {
        StringBuilder resultBuilder = new StringBuilder();
        for (TimeUnitConverter converter : timeUnitConverters) {
            resultBuilder.append(converter.convert(time)).append(LINE_SEPARATOR);
        }
        return resultBuilder.toString().trim();
    }
}
