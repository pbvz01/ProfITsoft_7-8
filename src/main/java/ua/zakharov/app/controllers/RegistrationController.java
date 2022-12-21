package ua.zakharov.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.zakharov.app.model.User;
import ua.zakharov.app.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("userValid", new User());
        return "registration";
    }

    @PostMapping
    public String registerUser(@Valid @ModelAttribute("userValid") User user, BindingResult bindingResult,
                               Model model) {
        if(bindingResult.hasErrors()) {
            return "registration";
        }

        if(userRepository.findByLogin(user.getUsername()) != null) {
            model.addAttribute("loginIsTaken",
                    "The user with this username was created. Change your the login");
            return "registration";
        }
        System.out.println("New user: " + user);
        userRepository.save(user);

        return "redirect:/login";
    }
}
