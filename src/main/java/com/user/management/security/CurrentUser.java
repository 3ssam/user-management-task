package com.user.management.security;

import com.user.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CurrentUser {

    @Autowired
    private static UserRepository userRepository;


    public static long getId() {
        return getPrincipal().map(MyUserDetails::getId).orElse((long) -1);
    }


    private static Optional<MyUserDetails> getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.ofNullable(authentication).map(auth -> ((MyUserDetails) auth.getPrincipal()));
    }
}
