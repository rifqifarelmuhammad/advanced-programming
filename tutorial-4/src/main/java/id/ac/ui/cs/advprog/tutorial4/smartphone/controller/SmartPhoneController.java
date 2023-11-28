package id.ac.ui.cs.advprog.tutorial4.smartphone.controller;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.SmartPhone;
import id.ac.ui.cs.advprog.tutorial4.smartphone.repository.SmartPhoneBrand;
import id.ac.ui.cs.advprog.tutorial4.smartphone.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//! Do not modify this file
@Controller
@RequestMapping(path = {"/smartphone"})
public class SmartPhoneController {
    private final SmartPhoneService smartPhoneService;

    @Autowired
    public SmartPhoneController(SmartPhoneService smartPhoneService) {
        this.smartPhoneService = smartPhoneService;
    }

    @GetMapping(path = {"", "/"})
    public String home(Model model, @RequestParam(required = false) String brandInput) {
        try{
            List<SmartPhoneBrand> brands = smartPhoneService.getAllBrands();
            model.addAttribute("brands", brands);

            if (brandInput != null) {
                SmartPhoneBrand smartPhoneBrand = SmartPhoneBrand.valueOf(SmartPhoneBrand.class, brandInput.toUpperCase());
                SmartPhone smartPhone = smartPhoneService.createSmartPhone(smartPhoneBrand);
                model.addAttribute("smartPhone", smartPhone);
            }
        } catch (Exception e) {
        // Do nothing
        }

        return "smartphone/home";
    }

}
