package br.com.buildit.controller;

import br.com.buildit.model.User;
import br.com.buildit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("save")
    public void saveUser(@RequestBody User user){
        userRepository.save(user);
    }

}
