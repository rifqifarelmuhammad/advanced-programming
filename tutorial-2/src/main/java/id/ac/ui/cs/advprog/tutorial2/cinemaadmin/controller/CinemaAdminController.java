package id.ac.ui.cs.advprog.tutorial2.cinemaadmin.controller;

import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.Devices;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.core.helper.FormDevices;
import id.ac.ui.cs.advprog.tutorial2.cinemaadmin.service.CinemaAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cinema-admin")
public class CinemaAdminController {
    @Autowired
    private CinemaAdminService cinemaAdminService;

    @GetMapping("/enable-device")
    public String enableDevice(Model model) {
        Devices devices= cinemaAdminService.getDevices();
        FormDevices form = new FormDevices(devices.getAc().getEnable(), devices.getLamp().getEnable(), devices.getScreen().getEnable());

        model.addAttribute("devices", devices);
        model.addAttribute("form", form);
        return "cinemaadmin/enabledevice";
    }

    @PostMapping("/enable-device")
    public String postEnableDevice(@ModelAttribute("form") FormDevices form) {
        cinemaAdminService.setDevices(form);
        cinemaAdminService.registryCommand(cinemaAdminService.getDevices());
        return "redirect:control-panel";
    }

    @GetMapping("/control-panel")
    public String adminPanel(Model model){
        Devices devices = cinemaAdminService.getDevices();
        List<String> history = cinemaAdminService.getHistory();

        model.addAttribute("devices", devices);
        model.addAttribute("history", history);
        return "cinemaadmin/controlpanel";
    }

    @GetMapping("/control-panel/{command}")
    public String executeCommand(@PathVariable("command")String command){
        cinemaAdminService.executeCommand(command);
        return "redirect:/cinema-admin/control-panel";
    }
}
