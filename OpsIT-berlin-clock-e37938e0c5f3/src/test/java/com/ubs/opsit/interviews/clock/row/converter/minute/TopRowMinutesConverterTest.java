package com.ubs.opsit.interviews.clock.row.converter.minute;

import com.ubs.opsit.interviews.clock.row.provider.minute.TopMinutesRowProvider;
import com.ubs.opsit.interviews.time.Time;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TopRowMinutesConverterTest {

    TopRowMinutesConverter topRowMinutesConverter = new TopRowMinutesConverter(new TopMinutesRowProvider());

    @Test
    public void shouldConvertMinutesInTopRow() {
        assertTopRowMinuteConversion( 0, "OOOOOOOOOOO");
        assertTopRowMinuteConversion( 1, "OOOOOOOOOOO");
        assertTopRowMinuteConversion( 4, "OOOOOOOOOOO");
        assertTopRowMinuteConversion( 5, "YOOOOOOOOOO");
        assertTopRowMinuteConversion( 9, "YOOOOOOOOOO");
        assertTopRowMinuteConversion(10, "YYOOOOOOOOO");
        assertTopRowMinuteConversion(14, "YYOOOOOOOOO");
        assertTopRowMinuteConversion(15, "YYROOOOOOOO");
        assertTopRowMinuteConversion(19, "YYROOOOOOOO");
        assertTopRowMinuteConversion(20, "YYRYOOOOOOO");
        assertTopRowMinuteConversion(24, "YYRYOOOOOOO");
        assertTopRowMinuteConversion(25, "YYRYYOOOOOO");
        assertTopRowMinuteConversion(29, "YYRYYOOOOOO");
        assertTopRowMinuteConversion(30, "YYRYYROOOOO");
        assertTopRowMinuteConversion(34, "YYRYYROOOOO");
        assertTopRowMinuteConversion(35, "YYRYYRYOOOO");
        assertTopRowMinuteConversion(39, "YYRYYRYOOOO");
        assertTopRowMinuteConversion(40, "YYRYYRYYOOO");
        assertTopRowMinuteConversion(44, "YYRYYRYYOOO");
        assertTopRowMinuteConversion(45, "YYRYYRYYROO");
        assertTopRowMinuteConversion(49, "YYRYYRYYROO");
        assertTopRowMinuteConversion(50, "YYRYYRYYRYO");
        assertTopRowMinuteConversion(54, "YYRYYRYYRYO");
        assertTopRowMinuteConversion(55, "YYRYYRYYRYY");
        assertTopRowMinuteConversion(59, "YYRYYRYYRYY");
    }

    private void assertTopRowMinuteConversion(int minutes, String expected) {
        Time time = createTimeWithMinutesOf(minutes);
        assertThat(topRowMinutesConverter.convert(time)).isEqualTo(expected);
    }

    private Time createTimeWithMinutesOf(int minutes) {
        return new Time(0, minutes, 0);
    }
}