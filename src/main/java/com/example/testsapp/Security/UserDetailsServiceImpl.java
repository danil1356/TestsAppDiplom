package com.example.testsapp.Security;

import com.example.testsapp.Security.jwt.JwtUser;
import com.example.testsapp.Security.jwt.JwtUserFactory;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
//выдача пользователю всех его разрешений
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    @Override
    //@Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Users user = usersService.findByLogin(login);

        if (user == null){
            throw new UsernameNotFoundException(login+" not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
