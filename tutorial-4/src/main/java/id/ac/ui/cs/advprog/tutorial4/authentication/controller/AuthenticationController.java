package id.ac.ui.cs.advprog.tutorial4.authentication.controller;

import id.ac.ui.cs.advprog.tutorial4.authentication.service.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Controller
@RequestMapping(path = "/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;
    
    @GetMapping(path = {""})
    public String menu() {
        return "authentication/menu";
    }
    
    @GetMapping(path = {"/login"})
    public String login() {
        return "authentication/login";
    }
    
    @PostMapping(path = {"/login"})
    public String loginPost(@RequestParam String username, @RequestParam String password, HttpServletResponse response){
        var token = authenticationService.login(username, password);
        var cookie = createCookie("token", token);
        response.addCookie(cookie);
        return "redirect:authorized";
    }
    
    @GetMapping(path = "/register")
    public String register() {
        return "authentication/register";
    }
    
    @PostMapping(path = {"/register"})
    public String registerPost(@RequestParam String username, @RequestParam String password){
        authenticationService.register(username, password);
        return "redirect:login";
    }
    
    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response,
                         @CookieValue(name="token", defaultValue = "") String token)  {
        // TODO.
        //  Jangan lupa pertimbangkan kasus di mana pengguna yang logged-out tetapi masih tetap menekan tombol log-out.
        //  Pada kasus tersebut, cukup redirect:login saja tanpa perlu mengeluarkan pesan apapun
        authenticationService.logout(token);

        return "redirect:login";
    }
    
    private static Cookie createCookie(String cookieName, String value){
        var newUrlEncoding = URLEncoder.encode(value, StandardCharsets.UTF_8);
        var oldUrlEncoding = newUrlEncoding.replace("+", "%20");
        var cookie = new Cookie(cookieName, oldUrlEncoding);
        cookie.setSecure(true);
        cookie.setHttpOnly(false);
        return cookie;
    }
    
    private static void clearAllCookies(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
