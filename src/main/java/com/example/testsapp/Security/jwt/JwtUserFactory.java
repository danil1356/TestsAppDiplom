package com.example.testsapp.Security.jwt;

import com.example.testsapp.data.Entity.Roles;
import com.example.testsapp.data.Entity.Status;
import com.example.testsapp.data.Entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static  JwtUser create(Users user)
    {
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSecond_name(),
                user.getMail(),
                user.getStatus().equals(Status.ACTIVE),
                setToGrantedAuthorities(new HashSet<>(user.getRolesSet()))
        );
    }

    private static List<GrantedAuthority> setToGrantedAuthorities(Set<Roles> rolesSet) {
        return rolesSet.stream().map(
                roles -> new SimpleGrantedAuthority(roles.getName())
        ).collect(Collectors.toList());
    }
}
