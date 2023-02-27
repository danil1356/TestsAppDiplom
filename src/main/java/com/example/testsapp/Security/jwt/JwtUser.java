package com.example.testsapp.Security.jwt;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {
    private final Long id;
    private final String login;
    private final String password;
    private final String name;
    private final String second_name;
    private final String mail;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;


    public JwtUser(Long id, String login, String password, String name, String second_name, String mail, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.second_name = second_name;
        this.mail = mail;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }


    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getMail() {
        return mail;
    }
}
