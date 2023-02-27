package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Roles;
import com.example.testsapp.representation.DTO.RolesDto;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    RolesDto getById(Long id);
    List<RolesDto> getAll();
    void save(Roles role);
    void delete(Long id);
}
