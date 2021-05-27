package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String createUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        } else if (!userService.passwordPass(userDto)) {
            bindingResult.rejectValue("secondPassword", "secondPassword", "Hasła nie są takie same");
            return "register";
        } else if(userService.userExist(userDto)){
            bindingResult.rejectValue("username", "Po co to jest?", "Użytkownik o takiej nazwie już istnieje");
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/";
    }
}
