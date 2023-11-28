package id.ac.ui.cs.advprog.tutorial7.day.counter.controller;

import id.ac.ui.cs.advprog.tutorial7.day.counter.core.WeekDay;
import id.ac.ui.cs.advprog.tutorial7.day.counter.dto.DayCounterDTO;
import id.ac.ui.cs.advprog.tutorial7.day.counter.service.DayCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/day-counter")
@RequiredArgsConstructor
public class DayCounterController {
    private final DayCounterService dayCounterService;

    @GetMapping(path = {"", "/"})
    public String getLeapYearPage(Model model) {
        List<String> days = Arrays.stream(WeekDay.values())
                .map(WeekDay::getDay)
                .collect(Collectors.toList());
        model.addAttribute("days", days);
        model.addAttribute("dto", new DayCounterDTO());
        return "day.counter/home";
    }

    @PostMapping(path = {"", "/"})
    public String postLeapYearPage(Model model, DayCounterDTO dto) {
        List<String> days = Arrays.stream(WeekDay.values())
                .map(WeekDay::getDay)
                .collect(Collectors.toList());
        String result = dayCounterService.getWeekDayAsString(dto.getDay(), dto.getN());
        model.addAttribute("days", days);
        model.addAttribute("dto", new DayCounterDTO());
        model.addAttribute("result", result);
        return "day.counter/home";
    }


}
