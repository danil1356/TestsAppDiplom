package com.example.testsapp.service;

import com.example.testsapp.data.Entity.QuestionType;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.QuestionTypeRepository;
import com.example.testsapp.representation.DTO.QuestionTypeDto;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService{

    @Autowired
    QuestionTypeRepository questionTypeRepository;
    @Override
    public QuestionTypeDto getById(Long id) {
        Optional<QuestionType> questionType = questionTypeRepository.findById(id);
        if (questionType.isEmpty()) {
            return null;
        }
        return QuestionTypeDto.toDto(questionType.get());
    }

    @Override
    public List<QuestionTypeDto> getAll() {
        List<QuestionType> questionTypes = questionTypeRepository.findAll();
        return questionTypes.stream().map(QuestionTypeDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(QuestionType type) {
        questionTypeRepository.save(type);
    }

    @Override
    public void delete(Long id) {
        questionTypeRepository.deleteById(id);
    }
}
