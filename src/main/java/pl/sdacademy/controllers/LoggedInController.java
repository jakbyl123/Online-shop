package pl.sdacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggedInController {
    public final static String PATH = "/logged-in";

    @GetMapping(PATH)
    public String getLoggedInPage() {
        return "login/logged-in";
    }

}
