package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Tests;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.TestsRepository;
import com.example.testsapp.representation.DTO.TestsDto;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestsServiceImpl implements TestsService{

    @Autowired
    TestsRepository testsRepository;

    @Override
    public TestsDto getById(Long id) {
        Optional<Tests> tests = testsRepository.findById(id);
        if (tests.isEmpty()) {
            return null;
        }
        return TestsDto.toDto(tests.get());
    }

    @Override
    public List<TestsDto> getAll() {
        List<Tests> tests = testsRepository.findAll();
        return tests.stream().map(TestsDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(Tests test) {
        testsRepository.save(test);
    }

    @Override
    public void delete(Long id) {
        testsRepository.deleteById(id);
    }
}
