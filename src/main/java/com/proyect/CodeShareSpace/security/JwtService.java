package com.proyect.CodeShareSpace.security;

import com.proyect.CodeShareSpace.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private List<String> tokensLogOuts = new ArrayList<>();

    public String createToken(User user){
        Date now = new Date();
        Date timeOfToken = new Date(now.getTime() + 300000000);

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

    public boolean validateToken(UserDetails userDetails,String token ){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token)
                && !tokensLogOuts.contains(token) ;
    }

    public String getUserNameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token , Function<Claims, T> function){
        Claims claims = getAllClaimsFromToken(token);
        return function.apply(claims);
    }

    public boolean isTokenExpired(String token){
        return new Date().after(getDateExpirationFromToken(token));
    }

    public Date getDateExpirationFromToken(String token){
        return getClaimFromToken(token,Claims::getExpiration);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    public String getTokenFromRequest(HttpServletRequest request){
        String bearer = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (bearer != null && bearer.startsWith("Bearer ")){
            return bearer.substring(7); // remueve la cabezera del token
        }
        return null;
    }

    public void tokenLogOut(String token){
        tokensLogOuts.add(token);
    }
}
