package com.ubs.opsit.interviews.time;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class TimeParser {

    private static final String TIME_UNIT_SEPARATOR = ":";
    private static final int MAX_HOUR = 24;
    private static final int MAX_MINUTE_OR_SECOND = 60;
    private static final int MIN_TIME_UNIT = 0;
    private static final int TIME_UNITS_NUMBER = 3;

    public Time parse(String timeString) {
        String[] timeUnits = timeString.split(TIME_UNIT_SEPARATOR);

        int hour = parseInt(timeUnits[0]);
        int minute = parseInt(timeUnits[1]);
        int second = parseInt(timeUnits[2]);

        validateTimeFormat(timeString, timeUnits);
        validateTimeRange(timeString, hour, minute, second);
        return new Time(hour, minute, second);
    }

    private void validateTimeRange(String timeString, int hour, int minute, int second) {
        if (!isTimeRangeValid(hour, minute, second) && !isMidnight(hour, minute, second)) {
            throw new IllegalArgumentException(format("%s is not valid time format", timeString));
        }
    }

    private void validateTimeFormat(String timeString, String[] timeUnits) {
        if (timeUnits.length != TIME_UNITS_NUMBER) {
            throw new IllegalArgumentException(
                    format("Invalid time format for: %s. Supported one is: 'HH:mm:ss'", timeString));
        }
    }

    private boolean isTimeRangeValid(int hour, int minute, int second) {
        return isHourValid(hour) && isMinuteOrSecondValid(minute) && isMinuteOrSecondValid(second);
    }

    private boolean isHourValid(int hour) {
        return hour >= MIN_TIME_UNIT && hour < MAX_HOUR;
    }

    private boolean isMinuteOrSecondValid(int minuteOrSecond) {
        return minuteOrSecond >= MIN_TIME_UNIT && minuteOrSecond < MAX_MINUTE_OR_SECOND;
    }

    private boolean isMidnight(int hour, int minute, int second) {
        return hour == MAX_HOUR && minute == MIN_TIME_UNIT && second == MIN_TIME_UNIT;
    }
}
