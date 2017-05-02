package com.ubs.opsit.interviews.clock.row.converter.second;

import com.ubs.opsit.interviews.clock.row.provider.second.SecondsRowProvider;
import com.ubs.opsit.interviews.time.Time;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SecondsConverterTest {

    private SecondsConverter secondsConverter = new SecondsConverter(new SecondsRowProvider());

    @Test
    public void shouldConvertSeconds() {
        assertSecondRowConversion( 1, "O");
        assertSecondRowConversion(31, "O");
        assertSecondRowConversion(59, "O");
        assertSecondRowConversion( 0, "Y");
        assertSecondRowConversion(30, "Y");
        assertSecondRowConversion(58, "Y");
    }

    private void assertSecondRowConversion(int seconds, String expectedResult) {
        Time time = createTimeWithSecondsOf(seconds);
        assertThat(secondsConverter.convert(time)).isEqualTo(expectedResult);
    }

    private Time createTimeWithSecondsOf(int seconds) {
        return new Time(0, 0, seconds);
    }
}