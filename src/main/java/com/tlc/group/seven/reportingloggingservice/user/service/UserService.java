package com.tlc.group.seven.reportingloggingservice.user.service;

import com.tlc.group.seven.reportingloggingservice.user.model.User;
import com.tlc.group.seven.reportingloggingservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository dataRepository;

    public List<User> getUsers(){
        return dataRepository.findAll();
    }
}
