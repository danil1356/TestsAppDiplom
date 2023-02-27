package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByLogin(String login);
}
