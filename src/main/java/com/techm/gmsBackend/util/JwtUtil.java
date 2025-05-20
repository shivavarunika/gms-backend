package com.techm.gmsBackend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import java.util.Date;

public class JwtUtil {
    private final static SecretKey SECRET     = Keys.hmacShaKeyFor("gms_secret".getBytes());
    private final static long      EXPIRATION = 1000 * 60 * 60; // 1 hour

    public static String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET).compact();
    }

    public static String getUserNameFromToken(String token) {
        Claims claims = extractClaim(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    public static boolean validateToken(String token, String username) {
        Claims claims = extractClaim(token);
        if (claims != null) {
            return claims.getSubject().equals(username) && !claims.getExpiration().before(new Date());
        }
        return false;
    }

    private static Claims extractClaim(String jwt) throws ExpiredJwtException {
        return Jwts.parser().setSigningKey(SECRET).build().parseClaimsJws(jwt).getBody();
    }

}
