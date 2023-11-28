package id.ac.ui.cs.advprog.tutorial7.day.counter.core;

import java.util.HashMap;
import java.util.Map;

public enum WeekDay {
    SUN("Sunday"),
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday");

    private final String day;

    WeekDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return this.day;
    }

    private static final Map<String, WeekDay> dayMap = new HashMap<>();

    public static WeekDay getWeekDay(String day){
        return WeekDay.dayMap.get(day.toLowerCase());
    }

    static {
        for (WeekDay day : WeekDay.values()) {
            dayMap.put(day.day.toLowerCase(), day);
        }
    }

}
