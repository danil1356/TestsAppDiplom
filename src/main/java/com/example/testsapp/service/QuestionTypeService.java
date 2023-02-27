package com.example.testsapp.service;


import com.example.testsapp.data.Entity.QuestionType;
import com.example.testsapp.representation.DTO.QuestionTypeDto;

import java.util.List;
import java.util.Optional;

public interface QuestionTypeService {
    QuestionTypeDto getById(Long id);
    List<QuestionTypeDto> getAll();
    void save(QuestionType type);
    void delete(Long id);
}
