package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}