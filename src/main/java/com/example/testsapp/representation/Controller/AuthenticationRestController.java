package com.example.testsapp.representation.Controller;

import com.example.testsapp.Security.jwt.JwtTokenProvider;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.representation.DTO.AuthRequestDto;
import com.example.testsapp.representation.DTO.UsersDto;
import com.example.testsapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/Auth")
public class AuthenticationRestController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UsersService usersService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UsersService usersService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AuthRequestDto authRequestDto){
        try {
            String login = authRequestDto.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, authRequestDto.getPassword()));
            Users user = usersService.findByLogin(login);

            if (user == null)
            {
                throw new UsernameNotFoundException("User with login "+login+" not found");
            }

            String token = jwtTokenProvider.createToken(login, user.getRolesSet());

            Map<Object, Object> response = new HashMap<>();
            response.put("login", login);
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid login or password");
        }
    }
}
