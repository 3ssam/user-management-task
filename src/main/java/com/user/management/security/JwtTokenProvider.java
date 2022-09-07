package com.user.management.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Component
public class JwtTokenProvider {
    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        MyUserDetails principal = (MyUserDetails) authentication.getPrincipal();
        var userScope = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        return Jwts.builder()
                .setHeaderParam("typ", "Bearer")
                .setSubject(String.valueOf(principal.getId()))
                .claim("usr", principal.getName())
                .claim("lgn", principal.getUsername())
                .claim("scp", userScope)
                .setIssuedAt(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public MyUserDetails getPrinciple(String token) {
        var body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        var builder = MyUserDetails.builder();
        builder.id(Long.valueOf(body.getSubject()));
        builder.email(body.get("lgn").toString());
        builder.name(body.get("usr").toString());
        builder.authorities(getAuthorities(body.get("scp").toString()));
        return builder.build();
    }

    private Set<GrantedAuthority> getAuthorities(String scp) {
        return Arrays.stream(scp.split(",")).map(n -> {
            return n.strip().replace(" ", "").replace("[", "").replace("]", "");
        }).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
