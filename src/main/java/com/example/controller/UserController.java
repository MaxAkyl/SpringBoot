package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    //localhost:8080/users
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/add-user")
    public String addUser(Model theModel) {
        theModel.addAttribute("user", new User());
        return "add-user";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model theModel) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update-user")
    public String editUser(@RequestParam("id") Long id, Model theModel) {
        theModel.addAttribute("user", userService.getById(id));
        return "add-user";
    }


    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

}
