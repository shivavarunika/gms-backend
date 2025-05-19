package com.techm.gmsBackend.controller;

import com.techm.gmsBackend.entity.GymUser;
import com.techm.gmsBackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody GymUser user) {
        return ResponseEntity.ok("User registered: " + userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest.getName(), loginRequest.getPassword());
        return ResponseEntity.ok(token);
    }

    static class LoginRequest {
        private String name;
        private String password;
        // Getters and setters
    }
}

//@RestController
//@RequestMapping("/v1/users")
//public class UserController {
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/add")
//    public String addUser(@RequestBody GymUser user) {
//        return userService.addUser(user);
//    }
//
//    @GetMapping("/get-all")
//    public List<GymUser> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/get-id/{id}")
//    public GymUser getUserById(@PathVariable long id) {
//        return userService.getUser(id);
//    }
//
//    @DeleteMapping("/delete-id/{id}")
//    public String deleteUserById(@PathVariable long id) {
//        return userService.deleteUser(id);
//    }
//
//
//}
