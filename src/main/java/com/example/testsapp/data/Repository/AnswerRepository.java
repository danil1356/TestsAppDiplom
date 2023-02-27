package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}