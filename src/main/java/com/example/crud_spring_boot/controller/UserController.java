package com.example.crud_spring_boot.controller;

import com.example.crud_spring_boot.model.User;
import com.example.crud_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String viewUserPage(Model model){
        model.addAttribute("listOfUsers", service.findAll());
        return "list-user";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "new-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/showUpdateUserForm/{id}")
    public String showUpdateUserForm(@PathVariable(value = "id") long id, Model model){
        User user = service.getById(id);

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        service.update(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id){
        service.delete(id);
        return "redirect:/users";
    }

}
