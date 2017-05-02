package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.clock.row.converter.TimeUnitConverter;
import com.ubs.opsit.interviews.clock.row.converter.hour.BottomRowHoursConverter;
import com.ubs.opsit.interviews.clock.row.converter.hour.TopRowHoursConverter;
import com.ubs.opsit.interviews.clock.row.converter.minute.BottomRowMinuteConverter;
import com.ubs.opsit.interviews.clock.row.converter.minute.TopRowMinutesConverter;
import com.ubs.opsit.interviews.clock.row.converter.second.SecondsConverter;
import com.ubs.opsit.interviews.clock.row.provider.hour.HourRowProvider;
import com.ubs.opsit.interviews.clock.row.provider.minute.BottomMinutesRowProvider;
import com.ubs.opsit.interviews.clock.row.provider.minute.TopMinutesRowProvider;
import com.ubs.opsit.interviews.clock.row.provider.second.SecondsRowProvider;

import java.util.ArrayList;
import java.util.List;

public class BerlinClockTimeUnitsConverterProvider {

    public BerlinClockTimeUnitsConverter create() {

        SecondsConverter secondsConverter = new SecondsConverter(new SecondsRowProvider());
        TopRowHoursConverter topRowHoursConverter = new TopRowHoursConverter(new HourRowProvider());
        BottomRowHoursConverter bottomRowHoursConverter = new BottomRowHoursConverter(new HourRowProvider());
        TopRowMinutesConverter topRowMinutesConverter = new TopRowMinutesConverter(new TopMinutesRowProvider());
        BottomRowMinuteConverter bottomRowMinuteConverter = new BottomRowMinuteConverter(
                new BottomMinutesRowProvider());

        List<TimeUnitConverter> converters = new ArrayList<>();
        converters.add(secondsConverter);
        converters.add(topRowHoursConverter);
        converters.add(bottomRowHoursConverter);
        converters.add(topRowMinutesConverter);
        converters.add(bottomRowMinuteConverter);

        return new BerlinClockTimeUnitsConverter(converters);
    }
}
