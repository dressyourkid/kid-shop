package ru.dressyourkid.kidshop.controller.login;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @GetMapping("/user")
    public Principal userInfo(Principal principal) {
        return principal;
    }

}
