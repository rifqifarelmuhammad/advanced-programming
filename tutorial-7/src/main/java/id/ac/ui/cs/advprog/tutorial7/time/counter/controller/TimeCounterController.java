package id.ac.ui.cs.advprog.tutorial7.time.counter.controller;

import id.ac.ui.cs.advprog.tutorial7.time.counter.dto.TimeCounterDTO;
import id.ac.ui.cs.advprog.tutorial7.time.counter.service.TimeCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/time-counter")
public class TimeCounterController {
    @Autowired
    private TimeCounterService timeCounterService;

    @GetMapping(path = {"", "/"})
    public String getTimeCounterPage(Model model) {
        model.addAttribute("ops", new String[]{"add", "subtract"});
        model.addAttribute("dto", new TimeCounterDTO());
        return "time.counter/home";
    }

    @PostMapping(path = {"", "/"})
    public String postTimeCounterPage(Model model, TimeCounterDTO dto) {
        String result = timeCounterService.calculateTime(
                dto.getTime(),
                dto.getHours(),
                dto.getMinutes(),
                dto.getOperation());
        model.addAttribute("ops", new String[]{"add", "subtract"});
        model.addAttribute("dto", new TimeCounterDTO());
        model.addAttribute("result", result);
        return "time.counter/home";
    }
}
