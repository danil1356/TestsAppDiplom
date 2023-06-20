package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.representation.DTO.StatisticsDto;

import java.util.List;
import java.util.Optional;

public interface StatisticsService {
    StatisticsDto getById(Long id);
    List<StatisticsDto> getAll();
    Statistics save(Statistics statistic);
    void delete(Long id);
}
