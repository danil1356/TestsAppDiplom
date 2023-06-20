package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.data.Repository.StatisticsRepository;
import com.example.testsapp.representation.DTO.StatisticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public StatisticsDto getById(Long id) {
        Optional<Statistics> statistics = statisticsRepository.findById(id);
        if (statistics.isEmpty()) {
            return null;
        }
        return StatisticsDto.toDto(statistics.get());
    }

    @Override
    public List<StatisticsDto> getAll() {
        List<Statistics> statistics = statisticsRepository.findAll();
        return statistics.stream().map(StatisticsDto::toDto).collect(Collectors.toList());
    }

    @Override
    public Statistics save(Statistics statistic) {
        Statistics statistics = statisticsRepository.save(statistic);
        return statistics;
    }

    @Override
    public void delete(Long id) {
        statisticsRepository.deleteById(id);
    }
}
