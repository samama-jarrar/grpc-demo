package com.example.grpcdemo.gateway.controller;

import com.example.grpcdemo.gateway.UserGrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserGrpcClient client;

    public UserController(UserGrpcClient client) {
        this.client = client;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return client.getUser(id).getName();
    }
}
