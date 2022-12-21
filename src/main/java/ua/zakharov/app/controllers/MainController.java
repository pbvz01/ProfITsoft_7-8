package ua.zakharov.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import ua.zakharov.app.model.User;
import ua.zakharov.app.repository.UserRepository;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/welcome")
    public String getWelcomePage(@SessionAttribute("user") User user, Model model) {
        model.addAttribute("userName", user.getName());
        return "welcome";
    }

    @GetMapping("/list-users")
    public String getHomePage(@SessionAttribute("user") User user, Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "list-users";
    }
}
