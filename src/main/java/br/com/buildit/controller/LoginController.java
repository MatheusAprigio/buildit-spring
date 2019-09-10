package br.com.buildit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("signin")
    public String getLogin(){
        return "signin";
    }

    @PostMapping("signin")
    public String authenticateUser(@PathParam("email") String email,  @PathParam("password") String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        return "redirect:/dashboard";
    }

    @GetMapping("signin/logout")
    public String logout(){
        return "signin";
    }

    @GetMapping("dashboard")
    public String getDashboard(){
        return "dashboard";
    }

}
