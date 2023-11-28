package id.ac.ui.cs.advprog.tutorial7.time.counter.dto;

import lombok.Data;

@Data
public class TimeCounterDTO {
    String time;
    int hours;
    int minutes;
    String operation;
}
