package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Questions;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.QuestionsRepository;
import com.example.testsapp.representation.DTO.QuestionsDto;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionsServiceImpl implements QuestionsService{

    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public QuestionsDto getById(Long id) {
        Optional<Questions> questions = questionsRepository.findById(id);
        if (questions.isEmpty()) {
            return null;
        }
        return QuestionsDto.toDto(questions.get());
    }

    @Override
    public List<QuestionsDto> getAll() {
        List<Questions> questions = questionsRepository.findAll();
        return questions.stream().map(QuestionsDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(Questions question) {
        questionsRepository.save(question);
    }

    @Override
    public void delete(Long id) {
        questionsRepository.deleteById(id);
    }
}
