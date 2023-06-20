package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
    Optional<Groups> findById(Long id);
}
