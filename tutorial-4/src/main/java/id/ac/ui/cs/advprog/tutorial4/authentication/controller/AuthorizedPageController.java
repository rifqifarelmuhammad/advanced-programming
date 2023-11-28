package id.ac.ui.cs.advprog.tutorial4.authentication.controller;

import id.ac.ui.cs.advprog.tutorial4.authentication.core.AuthentiationManager;
import id.ac.ui.cs.advprog.tutorial4.authentication.service.AuthorizedPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="auth")
public class AuthorizedPageController {
    @Autowired
    AuthorizedPageService authorizedPageService;
    
    @GetMapping(path = {"authorized"})
    public String authorizedPage(Model model, @CookieValue(name="token", defaultValue="") String token) {
        var username = authorizedPageService.getUsername(token);
        model.addAttribute("username", username);
        return "authentication/authorized-only";
    }
}
