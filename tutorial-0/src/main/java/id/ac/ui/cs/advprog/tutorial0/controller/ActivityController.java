package id.ac.ui.cs.advprog.tutorial0.controller;

import id.ac.ui.cs.advprog.tutorial0.model.Activity;
import id.ac.ui.cs.advprog.tutorial0.model.Day;
import id.ac.ui.cs.advprog.tutorial0.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @GetMapping("/list")
    public String activityListPage(Model model) {
        List<Activity> allActivities = service.findAll();
        model.addAttribute("activities", allActivities);
        return "activityList";
    }

    @GetMapping("/create")
    public String createActivityPage(Model model) {
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        return "createActivity";
    }

    @PostMapping("/create")
    public String createActivityPost(@ModelAttribute Activity activity, Model model) {
        service.create(activity);
        return "redirect:list";
    }

    @GetMapping("/list/{day}")
    public String indexWithPathVariable(@PathVariable("day") String day, Model model) {
        Day dayEnum = Day.valueOf(Day.class, day.toUpperCase());
        List<Activity> dayActivities = service.findByDay(dayEnum);
        model.addAttribute("activities", dayActivities);
        return "activityList";
    }

}
