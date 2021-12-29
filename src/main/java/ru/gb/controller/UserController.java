package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.User;
import ru.gb.service.UserService;


@Controller
@RequestMapping(value = "/")
public class UserController {

    //TODO must work with userService not repos
    private final UserService service;

    @Autowired
    public UserController(UserService service) {

        this.service = service;
    }

    @RequestMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping("/userList")
    public String userList(Model model) {model.addAttribute("allUsers", service.findAll());
        return "userListAdmin";
    }

    @GetMapping("/superAdmin")
    public String userListAll(Model model) {
        model.addAttribute("findAllUsers", service.findAll());
        return "superAdmin";
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @DeleteMapping("/userList")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            service.deleteById(userId);
        }
        return "redirect:/userList";
    }


    @GetMapping("/edit/{id}")
    public String updateUser (@PathVariable long id, Model model) {
        User user = service.findById(id);
        model.addAttribute("updateUser", user);
        return "updateUser";
    }
//
//    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
//    @PostMapping("/updateUser")
//    public String update(@RequestParam(required = true, defaultValue = "") long userId,
//                         @RequestParam(required = true, defaultValue = "") String action,
//                         Model model) {
//        if (action.equals("updateUser")) {
//            service.save(userId);
//        }
//        return "redirect:/updateUser";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userForm", new User());
        return "login";
    }

    @GetMapping("/user/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "redirect:/registration";
    }


    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            service.save(user);
            return "registration";
        }
        return "redirect:/";
    }
}
