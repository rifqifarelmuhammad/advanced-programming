package id.ac.ui.cs.advprog.tutorial2.template.controller;

import id.ac.ui.cs.advprog.tutorial2.template.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinema")
    public String cinemaHome() {
        return "template/cinema";
    }

    @GetMapping("/cinema/{type}")
    public String cinemaWatch(@PathVariable("type") String type, Model model) {
        Iterable<String> show;
        switch (type) {
            case "regular" -> show = cinemaService.startRegularShow();
            case "deluxe" -> show = cinemaService.startDeluxeShow();
            case "premiere" -> show = cinemaService.startPremiereShow();
            default -> {
                return "redirect:/template/cinema";
            }
        }
        model.addAttribute("Type", type.toUpperCase() + " CINEMA");
        model.addAttribute("Cinema", show);
        return "template/watch";
    }
}
