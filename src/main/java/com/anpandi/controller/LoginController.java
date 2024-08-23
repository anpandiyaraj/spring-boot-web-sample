package com.anpandi.controller;

import com.anpandi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes("username")
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        // Replace this with your actual authentication logic
        if (service.validateUser(username, password)) {
            model.addAttribute("welcomeMessage", "Welcome, " + username + "!");
            return "welcomePage";
        } else {
            model.addAttribute("errorMessage", "Invalid username or password.");
            return "loginPage";
        }
    }

}
