package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}