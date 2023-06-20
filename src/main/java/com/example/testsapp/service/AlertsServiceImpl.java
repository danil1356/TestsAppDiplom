package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Alerts;
import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.data.Repository.AlertsRepository;
import com.example.testsapp.data.Repository.StatisticsRepository;
import com.example.testsapp.representation.DTO.AlertsDto;
import com.example.testsapp.representation.DTO.StatisticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlertsServiceImpl implements AlertsService {

    final AlertsRepository alertsRepository;

    @Autowired
    public AlertsServiceImpl(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    @Override
    public AlertsDto getById(Long id) {
        Optional<Alerts> alerts = alertsRepository.findById(id);
        if (alerts.isEmpty()) {
            return null;
        }
        return AlertsDto.toDto(alerts.get());
    }

    @Override
    public List<AlertsDto> getAll() {
        List<Alerts> alerts = alertsRepository.findAll();
        return alerts.stream().map(AlertsDto::toDto).collect(Collectors.toList());
    }

    @Override
    public Alerts save(Alerts alert) {
        Alerts alerts = alertsRepository.save(alert);
        return alerts;
    }

    @Override
    public void delete(Long id) {
        alertsRepository.deleteById(id);
    }
}
