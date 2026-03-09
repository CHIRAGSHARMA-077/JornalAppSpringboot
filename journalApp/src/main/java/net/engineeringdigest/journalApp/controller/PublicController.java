package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Heath check controller is necessary
// to check the health of project while clicking url
@RestController

@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;
    // getMapping - when someone hits this URL run this method
    @GetMapping("/health-Check")
    public String healthCheck(){
        return "ok";
    }


    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
}
