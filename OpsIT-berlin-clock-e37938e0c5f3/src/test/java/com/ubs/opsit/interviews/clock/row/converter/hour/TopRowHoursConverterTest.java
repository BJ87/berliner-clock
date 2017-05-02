package com.ubs.opsit.interviews.clock.row.converter.hour;

import com.ubs.opsit.interviews.clock.row.provider.hour.HourRowProvider;
import com.ubs.opsit.interviews.time.Time;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TopRowHoursConverterTest {

    private TopRowHoursConverter topRowHoursConverter = new TopRowHoursConverter(new HourRowProvider());

    @Test
    public void shouldConvertHoursInTopRow() {
        assertHourConversionInTopRow( 0, "OOOO");
        assertHourConversionInTopRow( 4, "OOOO");
        assertHourConversionInTopRow( 5, "ROOO");
        assertHourConversionInTopRow( 9, "ROOO");
        assertHourConversionInTopRow(10, "RROO");
        assertHourConversionInTopRow(14, "RROO");
        assertHourConversionInTopRow(15, "RRRO");
        assertHourConversionInTopRow(19, "RRRO");
        assertHourConversionInTopRow(20, "RRRR");
        assertHourConversionInTopRow(23, "RRRR");
    }

    private void assertHourConversionInTopRow(int hours, String expectedResult) {
        Time time = createTimeWithHoursOf(hours);
        assertThat(topRowHoursConverter.convert(time)).isEqualTo(expectedResult);
    }

    private Time createTimeWithHoursOf(int hours) {
        return new Time(hours, 0, 0);
    }
}