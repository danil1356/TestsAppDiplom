package com.example.testsapp.service;


import com.example.testsapp.data.Entity.Questions;
import com.example.testsapp.representation.DTO.QuestionsDto;

import java.util.List;
import java.util.Optional;

public interface QuestionsService {
    QuestionsDto getById(Long id);
    List<QuestionsDto> getAll();
    void save(Questions question);
    void delete(Long id);
}
