package com.spring.security.security;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String typ;
    private String tkn;

    public AuthenticationResponse(String typ, String tkn) {
        this.typ = typ;
        this.tkn = tkn;
    }

    public AuthenticationResponse() {
    }
}
