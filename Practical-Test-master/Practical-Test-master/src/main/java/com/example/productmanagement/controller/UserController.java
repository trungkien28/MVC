package com.example.productmanagement.controller;

import com.example.productmanagement.entity.User;
import com.example.productmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login-user", method = RequestMethod.POST)
    public String loginUser(User user) {
        User registeredUser = userRepository.findByusername(user.getUsername());
        if (registeredUser == null) {
            return "redirect:/login?failMsg=Wrong username or password";
        }

        if (!registeredUser.getPassword().equals(user.getPassword())) {
            return "redirect:/login?failMsg=Wrong username or password";
        }

        return "redirect:/products";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public String registerUser(User user) {
        User registeredUser = userRepository.findByusername(user.getUsername());
        System.out.println(registeredUser);
        System.out.println(user);
        if (registeredUser != null) {
            return "redirect:/register?failMsg=Username already been taken";
        }

        userRepository.save(user);
        return "redirect:/products";
    }
}
