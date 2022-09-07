package com.user.management.controllers;

import com.user.management.models.DTO.UserDTO;
import com.user.management.response.ApiResponse;
import com.user.management.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "User", description = "this API for Do any CRUD Operation on User Entity")
public class UserController {


    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('CREATE_USER')")
    @PostMapping("signUp")
    public ApiResponse createUser(@Validated @RequestBody UserDTO userDTO) throws Exception {
        return ApiResponse.created(userService.createUser(userDTO));
    }


}
