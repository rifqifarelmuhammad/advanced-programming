package id.ac.ui.cs.advprog.tutorial7.day.counter.service;

import id.ac.ui.cs.advprog.tutorial7.day.counter.core.WeekDay;
import org.springframework.stereotype.Service;

import static java.lang.Math.abs;

@Service
public class DayCounterServiceImpl implements DayCounterService {
    @Override
    public String getWeekDayAsString(String day, int n) {
        WeekDay fromDayEnum = getFromDayEnum(day);
        String fromDay = fromDayEnum.getDay();

        int newDayIndex = calculateNewDayIndex(fromDayEnum, n);
        String toDay = WeekDay.values()[newDayIndex].getDay();

        final String toBe = n < 0 ? "was" : "is";
        final String timeToBe = n < 0 ? "ago before" : "in the future after";

        return String.format("%d day(s) %s %s %s %s.", abs(n), timeToBe, fromDay, toBe, toDay);
    }

    private WeekDay getFromDayEnum(String day) {
        if (WeekDay.getWeekDay(day) == null) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }

        return WeekDay.getWeekDay(day);
    }

    private int calculateNewDayIndex(WeekDay fromDayEnum, int n){
        if ((fromDayEnum.ordinal() + n) % 7 < 0){
            return (fromDayEnum.ordinal() + n) % 7 + 7;
        }

        return (fromDayEnum.ordinal() + n) % 7;
    }
}
