package com.todoApp.todolistApp.MyConfig;

import com.todoApp.todolistApp.Entity.UserInfo;
import com.todoApp.todolistApp.TodoRepo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo>userInfo=userInfoRepo.findByEmail(username);
        return userInfo.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found"+username));

    }
}
