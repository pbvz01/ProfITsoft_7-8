package ua.zakharov.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import ua.zakharov.app.filter.jwt.JwtProvider;
import ua.zakharov.app.model.User;
import ua.zakharov.app.repository.UserRepository;

@Controller
@RequestMapping("/auth")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/")
    public String startAuth() {
        return "redirect:/login";
    }

    @GetMapping("/welcome")
    public String getWelcomePage(@SessionAttribute(value = "token") String token, Model model) {
        User user = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        model.addAttribute("userName", user.getName());
        return "welcome";
    }

    @GetMapping("/list-users")
    public String getListOfUsersPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "list-users";
    }
}
