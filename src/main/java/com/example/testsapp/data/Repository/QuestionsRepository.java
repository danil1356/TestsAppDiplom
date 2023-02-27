package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}