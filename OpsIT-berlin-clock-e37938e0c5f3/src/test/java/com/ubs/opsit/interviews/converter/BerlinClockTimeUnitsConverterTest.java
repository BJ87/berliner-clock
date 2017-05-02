package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.clock.row.converter.TimeUnitConverter;
import com.ubs.opsit.interviews.time.Time;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.ubs.opsit.interviews.converter.BerlinClockTimeUnitsConverter.LINE_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BerlinClockTimeUnitsConverterTest {

    private static final String CONVERTED_SECONDS = "Y";
    private static final String CONVERTED_HOURS = "RRRR";
    private static final String CONVERTED_MINUTES = "OOOO";
    private static final Time TIME = new Time(1, 2, 3);

    private TimeUnitConverter secondsConverter = mock(TimeUnitConverter.class);
    private TimeUnitConverter minutesConverter = mock(TimeUnitConverter.class);
    private TimeUnitConverter hoursConverter = mock(TimeUnitConverter.class);

    private BerlinClockTimeUnitsConverter berlinClockTimeUnitsConverter;

    @Before
    public void setUp() {
        List<TimeUnitConverter> timeConverters = new ArrayList<>();
        timeConverters.add(secondsConverter);
        timeConverters.add(hoursConverter);
        timeConverters.add(minutesConverter);
        berlinClockTimeUnitsConverter = new BerlinClockTimeUnitsConverter(timeConverters);
    }

    @Test
    public void shouldConvertEachTimeUnitAndCombineResult() {
        when(secondsConverter.convert(TIME)).thenReturn(CONVERTED_SECONDS);
        when(hoursConverter.convert(TIME)).thenReturn(CONVERTED_HOURS);
        when(minutesConverter.convert(TIME)).thenReturn(CONVERTED_MINUTES);

        String result = berlinClockTimeUnitsConverter.convert(TIME);

        assertThat(result).isEqualTo(expectedResult());
    }

    private String expectedResult() {
        return new StringBuilder().append(CONVERTED_SECONDS).append(LINE_SEPARATOR)
                .append(CONVERTED_HOURS).append(LINE_SEPARATOR)
                .append(CONVERTED_MINUTES).toString();
    }

}