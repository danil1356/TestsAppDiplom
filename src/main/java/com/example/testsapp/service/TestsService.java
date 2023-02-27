package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Tests;
import com.example.testsapp.representation.DTO.TestsDto;

import java.util.List;
import java.util.Optional;

public interface TestsService {
    TestsDto getById(Long id);
    List<TestsDto> getAll();
    void save(Tests test);
    void delete(Long id);
}
