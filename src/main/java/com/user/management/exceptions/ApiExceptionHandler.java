package com.user.management.exceptions;

import com.user.management.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiResponse accessDeniedExceptionHandler(AccessDeniedException ex) {
        return new ApiResponse(403,HttpStatus.FORBIDDEN.toString(), "common.security.forbidden", ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse badCredentialsExceptionHandler(BadCredentialsException ex) {
        return new ApiResponse(401,HttpStatus.UNAUTHORIZED.toString(), "common.security.unauthorized", "Invalid credentials!");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse genericExceptionHandler(Exception ex) {
        return new ApiResponse(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Error, internal server error", ex.getMessage());
    }
}
