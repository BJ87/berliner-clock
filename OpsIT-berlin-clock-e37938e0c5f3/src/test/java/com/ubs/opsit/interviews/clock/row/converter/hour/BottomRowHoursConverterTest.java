package com.ubs.opsit.interviews.clock.row.converter.hour;

import com.ubs.opsit.interviews.clock.row.provider.hour.HourRowProvider;
import com.ubs.opsit.interviews.time.Time;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BottomRowHoursConverterTest {

    private BottomRowHoursConverter bottomRowHoursConverter = new BottomRowHoursConverter(new HourRowProvider());

    @Test
    public void shouldConvertHoursInBottomRow() {
        assertHourConversionInBottomRow( 0, "OOOO");
        assertHourConversionInBottomRow( 5, "OOOO");
        assertHourConversionInBottomRow(15, "OOOO");
        assertHourConversionInBottomRow( 1, "ROOO");
        assertHourConversionInBottomRow(11, "ROOO");
        assertHourConversionInBottomRow(21, "ROOO");
        assertHourConversionInBottomRow(12, "RROO");
        assertHourConversionInBottomRow(22, "RROO");
        assertHourConversionInBottomRow(23, "RRRO");
        assertHourConversionInBottomRow( 4, "RRRR");
        assertHourConversionInBottomRow(14, "RRRR");
    }

    private void assertHourConversionInBottomRow(int hours, String expectedResult) {
        Time time = createTimeWithHoursOf(hours);
        assertThat(bottomRowHoursConverter.convert(time)).isEqualTo(expectedResult);
    }

    private Time createTimeWithHoursOf(int hours) {
        return new Time(hours, 0, 0);
    }
}