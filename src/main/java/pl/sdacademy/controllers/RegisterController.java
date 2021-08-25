package pl.sdacademy.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdacademy.user.User;
import pl.sdacademy.user.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getRegistrationForm(@ModelAttribute("user") User user){
        return "registration/registration-form";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("user")@Validated User user, BindingResult bindingResult){
        if(userService.doesUserExist(user.getUsername())){
            FieldError fieldError = new FieldError("user", "username", "uzytkownik juz istnieje");
            bindingResult.addError(fieldError);
        }
        if (bindingResult.hasErrors()){
            return "registration/registration-form";
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        return "registration/registration-result";
    }
}
