package com.app.controller;

import com.app.dto.UserRequestDTO;
import com.app.dto.UserResponseDTO;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{uname}")
    public ResponseEntity<UserResponseDTO> getUserByName(@PathVariable String uname) {
        return ResponseEntity.ok(userService.getUserByName(uname));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(201).body(userService.addUser(userRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    // Other user-related endpoints
}
