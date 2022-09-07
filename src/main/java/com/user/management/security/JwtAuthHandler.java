package com.user.management.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException {
        res.setStatus(401);
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");
        res.getWriter().println("HTTP Status 401 - " + e.getMessage());
    }
}
