package com.todoApp.todolistApp.Controller;

import com.todoApp.todolistApp.Entity.Todo;
import com.todoApp.todolistApp.Entity.UserInfo;
import com.todoApp.todolistApp.Service.UserService;
import com.todoApp.todolistApp.TodoRepo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserService userService;
    @GetMapping(value = "/welcome")
    public List<Todo> findAll(){
        return todoRepo.findAll();
    }
    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Optional<Todo> findById(@PathVariable Long id){
        return todoRepo.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Todo save(@RequestBody Todo todo){
        return todoRepo.save(todo);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo){
        return todoRepo.save(todo);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        todoRepo.deleteById(id);
    }

}
