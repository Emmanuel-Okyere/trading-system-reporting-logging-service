package com.tlc.group.seven.reportingloggingservice.user.service;

import com.tlc.group.seven.reportingloggingservice.constant.AppConstant;
import com.tlc.group.seven.reportingloggingservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getUsers(){
        if(userRepository.findAll().isEmpty()){
            Map<?, ?> responseBody = Map.of("status", AppConstant.noContentStatus, "data", AppConstant.getNoDataAvailableMessage);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(responseBody);
        }
        Map<?, ?> responseBody = Map.of("status", AppConstant.successStatus, "message", AppConstant.getDataSuccessMessage, "data", userRepository.findAll());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBody);
    }
}
