package com.ubs.opsit.interviews.clock.row.converter.minute;

import com.ubs.opsit.interviews.clock.row.provider.minute.BottomMinutesRowProvider;
import com.ubs.opsit.interviews.time.Time;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BottomRowMinuteConverterTest {

    BottomRowMinuteConverter bottomRowMinuteConverter = new BottomRowMinuteConverter(new BottomMinutesRowProvider());

    @Test
    public void shouldConvertMinutesInBottomRow() {
        assertBottomRowMinuteConversion( 1, "YOOO");
        assertBottomRowMinuteConversion(31, "YOOO");
        assertBottomRowMinuteConversion(51, "YOOO");
        assertBottomRowMinuteConversion( 2, "YYOO");
        assertBottomRowMinuteConversion(12, "YYOO");
        assertBottomRowMinuteConversion(52, "YYOO");
        assertBottomRowMinuteConversion( 3, "YYYO");
        assertBottomRowMinuteConversion(53, "YYYO");
        assertBottomRowMinuteConversion( 4, "YYYY");
        assertBottomRowMinuteConversion(54, "YYYY");
        assertBottomRowMinuteConversion(59, "YYYY");
    }

    private void assertBottomRowMinuteConversion(int minutes, String expectedResult) {
        Time time = createTimeWithMinutesOf(minutes);
        assertThat(bottomRowMinuteConverter.convert(time)).isEqualTo(expectedResult);
    }

    private Time createTimeWithMinutesOf(int minutes) {
        return new Time(0, minutes, 0);
    }
}