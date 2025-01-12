package com.proyect.CodeShareSpace.security;

import com.proyect.CodeShareSpace.persistence.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    public String createToken(User user){
        Date now = new Date();
        Date timeOfToken = new Date(now.getTime() + 30000 );

        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId",user.getUserId())
                .claim("completeName",user.getCompleteName())
                .claim("rol",user.getRol())
                .setIssuedAt(now)
                .setExpiration(timeOfToken)
                .signWith(key)
                .compact();

        return token;
    }
}
