package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Tests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestsRepository extends JpaRepository<Tests, Long> {
}