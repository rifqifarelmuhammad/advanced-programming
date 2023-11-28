package id.ac.ui.cs.advprog.tutorial7.leap.year.controller;

import id.ac.ui.cs.advprog.tutorial7.leap.year.dto.LeapYearDTO;
import id.ac.ui.cs.advprog.tutorial7.leap.year.service.LeapYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/leap-year")
@RequiredArgsConstructor
public class LeapYearController {
    private final LeapYearService leapYearService;

    @GetMapping(path = {"", "/"})
    public String getLeapYearPage(Model model) {
        model.addAttribute("dto", new LeapYearDTO());
        return "leap.year/home";
    }

    @PostMapping(path = {"", "/"})
    public String postLeapYearPage(Model model, LeapYearDTO dto) {
        String result = leapYearService.getYearCategoryAsString(dto.getYear());
        model.addAttribute("dto", new LeapYearDTO());
        model.addAttribute("result", result);
        return "leap.year/home";
    }
}
