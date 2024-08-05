package com.jahcodework.universal_pet_care.controller;

import com.jahcodework.universal_pet_care.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
}
