package ua.zakharov.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.zakharov.app.filter.jwt.JwtProvider;
import ua.zakharov.app.model.User;
import ua.zakharov.app.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String auth(@RequestParam("login") String login, @RequestParam("password") String password,
                       Model model, HttpServletRequest request) {
        User user = userRepository.findByLoginAndPassword(login, password);
        if(user == null) {
            model.addAttribute("authError", "Incorrect login or password.");
            return "login";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("token", jwtProvider.generateToken(user.getUsername()));
        return "redirect:/auth/welcome";
    }
}
