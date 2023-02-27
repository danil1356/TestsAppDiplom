package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Answer;
import com.example.testsapp.representation.DTO.AnswerDto;

import java.util.List;

public interface AnswerService {
    AnswerDto getById(Long id);
    List<AnswerDto> getAll();
    void save(Answer answer);
    void delete(Long id);
}
