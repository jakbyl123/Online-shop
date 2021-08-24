package pl.sdacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoggedInController {
    public final static String PATH = "/logged-in";

    @GetMapping(PATH)
    public String getLoggedInPage(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "login/admin-panel";
        }

        return "login/logged-in";
    }

}
