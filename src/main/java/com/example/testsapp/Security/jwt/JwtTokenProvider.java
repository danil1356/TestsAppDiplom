package com.example.testsapp.Security.jwt;

import com.example.testsapp.data.Entity.Roles;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class JwtTokenProvider {
    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private long timeToValideInMS;

    @Autowired
    UserDetailsService userDetailsService;

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes(StandardCharsets.UTF_8));
    }


    public String createToken(String login, Set<Roles> rolesSet)
    {
        Claims claims = Jwts.claims().setSubject(login);
        claims.put("roles", getRoleName(rolesSet));

        Date now = new Date();
        Date validity = new Date(now.getTime()+timeToValideInMS);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Authentication getAuthentication(String token)
    {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getLogin(token));
        //System.out.println(userDetails.getAuthorities()+ " asdasdasda");
        return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
    }

    public String getLogin (String token)
    {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    //анализ токена
    public String resolveToken(HttpServletRequest req)
    {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String token)
    {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            if (claimsJws.getBody().getExpiration().before(new Date())){
                return false;
            }

            return true;
        } catch (JwtException | IllegalArgumentException e){
            throw new JwtAuthenticationException("JWT token is expired or invalid");
        }
    }

    private List<String> getRoleName(Set<Roles> userRoles)
    {
        List<String> result = new ArrayList<>();

        userRoles.forEach(roles -> {
            result.add(roles.getName());
        });

        return result;
    }
}
