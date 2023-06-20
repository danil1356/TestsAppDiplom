package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Alerts;
import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.representation.DTO.AlertsDto;

import java.util.List;

public interface AlertsService {

    AlertsDto getById(Long id);
    List<AlertsDto> getAll();
    Alerts save(Alerts alerts);
    void delete(Long id);
}
