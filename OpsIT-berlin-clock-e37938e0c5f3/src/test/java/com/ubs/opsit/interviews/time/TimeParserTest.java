package com.ubs.opsit.interviews.time;

import org.junit.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class TimeParserTest {

    TimeParser timeParser = new TimeParser();

    @Test
    public void shouldParseTime() {
        assertTimeParsing("00:00:00", time(0, 0, 0));
        assertTimeParsing("01:02:03", time(1, 2, 3));
        assertTimeParsing("10:11:12", time(10, 11, 12));
        assertTimeParsing("23:59:59", time(23, 59, 59));
        assertTimeParsing("24:00:00", time(24, 00, 00));
    }

    @Test
    public void shouldThrowExceptionWhileParsingInvalidTime() {
        assertExceptionThrownFor("24:00:01");
        assertExceptionThrownFor("-01:00:00");
        assertExceptionThrownFor("25:00:00");
        assertExceptionThrownFor("00:-01:00");
        assertExceptionThrownFor("00:60:00");
        assertExceptionThrownFor("00:00:-01");
        assertExceptionThrownFor("00:00:60");
    }

    private void assertExceptionThrownFor(String timeToParse) {
        try {
            timeParser.parse(timeToParse);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail(format("Expected exception not thrown for time: %s", timeToParse));
    }

    public void assertTimeParsing(String timeToParse, Time expectedTime) {
        Time result = timeParser.parse(timeToParse);
        assertThat(result).isEqualTo(expectedTime);
    }

    private Time time(int hour, int minute, int second) {
        return new Time(hour, minute, second);
    }

}