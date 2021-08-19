package com.birthday.controller;

import com.birthday.model.Role;
import com.birthday.model.User;
import com.birthday.model.UserRole;
import com.birthday.repo.UserRepository;
import com.birthday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin ("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("users")
    public List<User> getUsers(){
        return this.userRepository.findAll();

    }

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles=new HashSet<>();

        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);

        return this.userService.createUser(user,roles);

    }


    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //delete the user by id

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }


}
