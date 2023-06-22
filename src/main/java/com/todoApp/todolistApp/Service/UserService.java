package com.todoApp.todolistApp.Service;

import com.todoApp.todolistApp.Entity.UserInfo;
import com.todoApp.todolistApp.TodoRepo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepo.save(userInfo);
        return "user added successfully";
    }
}
