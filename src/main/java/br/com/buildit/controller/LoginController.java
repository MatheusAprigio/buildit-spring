package br.com.buildit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("signin")
    public String getLogin(){
        return "signin";
    }

    @GetMapping("")
    public String getInitialSlash(){
        return "forms/overview";
    }

}
