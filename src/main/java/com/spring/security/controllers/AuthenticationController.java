package com.spring.security.controllers;

import com.spring.security.security.AuthenticationRequest;
import com.spring.security.security.AuthenticationResponse;
import com.spring.security.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public AuthenticationResponse authenticate(@Validated @RequestBody AuthenticationRequest req) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
        Authentication authentication = authManager.authenticate(authenticationToken);
        return new AuthenticationResponse("Bearer", jwtTokenProvider.generateToken(authentication));
    }
}
