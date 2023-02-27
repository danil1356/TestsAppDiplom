package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Answer;
import com.example.testsapp.data.Repository.AnswerRepository;
import com.example.testsapp.representation.DTO.AnswerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public AnswerDto getById(Long id) {
        Optional<Answer> answer = answerRepository.findById(id);
        if (answer.isEmpty()) {
            return null;
        }
        return AnswerDto.toDto(answer.get());
    }

    @Override
    public List<AnswerDto> getAll() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream().map(AnswerDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void delete(Long id) {
        answerRepository.deleteById(id);
    }
}
