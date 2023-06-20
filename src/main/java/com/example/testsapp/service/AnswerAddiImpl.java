package com.example.testsapp.service;

import com.example.testsapp.data.Entity.AnswerAddi;
import com.example.testsapp.data.Repository.AnswerAddiRepository;
import com.example.testsapp.representation.DTO.AnswerAddiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerAddiImpl implements AnswerAddiService{

    @Autowired
    AnswerAddiRepository answerAddiRepository;

    @Override
    public AnswerAddiDto getById(Long id) {
        Optional<AnswerAddi> answerAddi = answerAddiRepository.findById(id);
        if (answerAddi.isEmpty()){
            return null;
        }
        return AnswerAddiDto.toDto(answerAddi.get());
    }

    @Override
    public List<AnswerAddiDto> getAll() {
        List<AnswerAddi> answerAddis = answerAddiRepository.findAll();
        return answerAddis.stream().map(AnswerAddiDto::toDto).collect(Collectors.toList());
    }

    @Override
    public AnswerAddi save(AnswerAddi answerAddi) {
        AnswerAddi addi = answerAddiRepository.save(answerAddi);
        return addi;
    }

    @Override
    public void delete(Long id) {
        answerAddiRepository.deleteById(id);
    }
}
