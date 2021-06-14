package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.EmailDto;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("emailDto", new EmailDto());
        return "login";
    }


    @GetMapping("/register")
    public String createUser(Model model) {
        model.addAttribute("emailDto", new EmailDto());
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute EmailDto emailDto, @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        } else if (!userService.checkPassword(userDto)) {
            bindingResult.rejectValue("password", "error.password");
            return "register";
        } else if (userService.userExist(userDto)) {
            bindingResult.rejectValue("username", "error.user");
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/";
    }



}
