package com.guner.springevent.controller;

import com.guner.springevent.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRegistrationService userRegistrationService;

    @GetMapping("/createUser")
    public String createUser(@RequestParam(name = "user", required = true) String user) {
        userRegistrationService.registerUser(user);
        return "Hello new User " + user;
    }

}