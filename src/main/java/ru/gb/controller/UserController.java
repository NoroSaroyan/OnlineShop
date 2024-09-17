package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.User;
import ru.gb.service.UserService;
import ru.gb.MethodUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String index(){
        return "redirect:user/login";
    }

    @RequestMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "/user/login";
    }

    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("isNew", true);
        model.addAttribute("userForm", new User());
        return "user/form";
    }

    @GetMapping("/edit/{id}")
    public String userOne(@PathVariable Long id, Model model) {
        model.addAttribute("isNew", false);
        model.addAttribute("userForm", service.findOne(id));
        return "user/form";
    }

//    @GetMapping(value = "/delete/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public @ResponseBody String userDelete(@PathVariable Long id) {
//        return service.deleteById(id);
//    }
//
//    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public @ResponseBody String userAdd(@RequestBody User user, BindingResult result) {
//        if(result.hasErrors()) {
//            return ErrorUtils.customErrors(result.getAllErrors());
//        } else {
//            return service.addUser(user);
//        }
//    }

    @GetMapping("/list/{id}")
    public User findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String userList(Model model, Pageable pageable) {
        Page<User> pages = service.findAll(pageable);
        model.addAttribute("users", pages.getContent());
        MethodUtils.pageModel(model, pages);
        return "/user/list";
    }

    @GetMapping("/refresh")
    public String refreshCache(Model model, Pageable pageable) {
//        service.refreshCache();
        Page<User> pages = service.findAll(pageable);
        model.addAttribute("users", pages.getContent());
        MethodUtils.pageModel(model, pages);
        return "/user/list";
    }
//
//    @RequestMapping("/login")
//    public String login(){
//        return "user/login";
//    }

//    @GetMapping("/userList")
//    public String userList(Model model) {model.addAttribute("allUsers", service.findAll());
//        return "userListAdmin";
//    }
//
//    @GetMapping("/superAdmin")
//    public String userListAll(Model model) {
//        model.addAttribute("findAllUsers", service.findAll());
//        return "superAdmin";
////    }
//
//    @GetMapping("")
//    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
//    @DeleteMapping("/userList")
//    public String deleteUser(@RequestParam(required = true, defaultValue = "") long userId,
//                             @RequestParam(required = true, defaultValue = "") String action,
//                             Model model) {
//        if (action.equals("delete")) {
//            service.deleteById(userId);
//        }
//        return "redirect:/userList";
//    }


//    @GetMapping("/edit/{id}")
//    public String updateUser (@PathVariable long id, Model model) {
//        User user = service.findById(id);
//        model.addAttribute("updateUser", user);
//        return "updateUser";
//    }
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

//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("userForm", new User());
//        return "login";
//    }
//
//    @GetMapping("/user/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//        return "redirect:/registration";
//    }

//
//    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
//    @PostMapping("/registration")
//    public String addUser(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            service.save(user);
//            return "registration";
//        }
//        return "redirect:/";
//    }
}
