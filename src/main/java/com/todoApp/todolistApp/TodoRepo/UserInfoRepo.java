package com.todoApp.todolistApp.TodoRepo;

import com.todoApp.todolistApp.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {
    Optional<UserInfo> findByEmail(String username);
}
