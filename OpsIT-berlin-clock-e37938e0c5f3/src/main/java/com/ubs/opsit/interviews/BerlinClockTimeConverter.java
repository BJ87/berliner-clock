package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.converter.BerlinClockTimeUnitsConverter;
import com.ubs.opsit.interviews.converter.BerlinClockTimeUnitsConverterProvider;
import com.ubs.opsit.interviews.time.Time;
import com.ubs.opsit.interviews.time.TimeParser;

public class BerlinClockTimeConverter implements TimeConverter {

    private final TimeParser timeParser;
    private final BerlinClockTimeUnitsConverter berlinClockTimeUnitsConverter;

    public BerlinClockTimeConverter(TimeParser timeParser,
                                    BerlinClockTimeUnitsConverter berlinClockTimeUnitsConverter) {
        this.timeParser = timeParser;
        this.berlinClockTimeUnitsConverter = berlinClockTimeUnitsConverter;
    }

    @Override
    public String convertTime(String aTime) {
        Time time = timeParser.parse(aTime);
        return berlinClockTimeUnitsConverter.convert(time);
    }

    //For JBehave test purpose
    public static BerlinClockTimeConverter create() {
        TimeParser timeParser = new TimeParser();
        BerlinClockTimeUnitsConverter berlinClockTimeUnitsConverter =
                new BerlinClockTimeUnitsConverterProvider().create();
        return new BerlinClockTimeConverter(timeParser, berlinClockTimeUnitsConverter);
    }
}
