package id.ac.ui.cs.advprog.tutorial7.time.counter.service;

import org.springframework.stereotype.Service;

@Service
public class TimeCounterServiceImpl implements TimeCounterService {
    @Override
    public String calculateTime(String time, int hours, int minutes, String operation) {
        String[] parts = time.split(":");
        int totalMinutes = getTotalMinutes(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        boolean isAdd = operation.equals("add");

        final String result = isAdd ? add(totalMinutes, hours, minutes):subtract(totalMinutes, hours, minutes);

        return printResult(time, hours, minutes, isAdd, result);
    }

    private String add(int totalMinutes, int hours, int minutes) {
        totalMinutes += getTotalMinutes(hours, minutes);

        return getNewTime(totalMinutes);
    }

    private String subtract(int totalMinutes, int hours, int minutes) {
        totalMinutes -= getTotalMinutes(hours, minutes);

        // handle negative value
        totalMinutes = (totalMinutes % (24 * 60)) + 24 * 60;

        return getNewTime(totalMinutes);
    }

    private int getTotalMinutes(int hours, int minutes) {
        return hours * 60 + minutes;
    }

    private String getNewTime(int totalMinutes){
        return String.format("%02d:%02d", (totalMinutes / 60) % 24, totalMinutes % 60);
    }

    private String printResult(String time, int hours, int minutes, boolean add, String result) {
        if (hours == 0 && minutes == 0) {
            return result;
        }

        final String toBe = add ? "after":"before";
        String hourText = getTextTime("hour", hours);
        String minuteText = getTextTime("minute", minutes);
        return String.format("%s%s%s %s is %s", hourText, minuteText, toBe, time, result);
    }

    private String getTextTime(String timeType, int n) {
        switch (n) {
            case 0:
                return "";
            case 1:
                return String.format("%d %s ", n, timeType);
            default:
                return String.format("%d %ss ", n, timeType);
        }
    }
}
