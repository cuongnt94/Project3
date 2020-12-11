package com.bfs.authserver.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static String generateToken(String signingKey, int[] data) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .claim("userID:", data[0])
                .claim("roleID:", data[1])
                .claim("permissionID:", data[2]);


        return builder.compact();
    }
}
