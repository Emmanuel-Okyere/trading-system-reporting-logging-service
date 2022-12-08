package com.tlc.group.seven.reportingloggingservice.user.controller;

import com.tlc.group.seven.reportingloggingservice.user.model.User;
import com.tlc.group.seven.reportingloggingservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/reports")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ResponseEntity<?> getUsers(){
        return userService.getUsers();
    }
}
