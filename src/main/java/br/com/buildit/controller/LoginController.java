package br.com.buildit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("signin")
    public String getLogin(){
        return "signin";
    }

    @GetMapping("")
    public String getInitialSlash(RedirectAttributes redirectAttributes){
        return "redirect:/order/list";
    }
}
