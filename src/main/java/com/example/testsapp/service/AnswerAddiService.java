package com.example.testsapp.service;

import com.example.testsapp.data.Entity.AnswerAddi;
import com.example.testsapp.representation.DTO.AnswerAddiDto;

import java.util.List;

public interface AnswerAddiService {

    AnswerAddiDto getById(Long id);
    List<AnswerAddiDto> getAll();
    AnswerAddi save (AnswerAddi answerAddi);
    void delete(Long id);
}
