package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Themes;
import com.example.testsapp.representation.DTO.ThemesDto;


import java.util.List;
import java.util.Optional;

public interface ThemesService {
    ThemesDto getById(Long id);
    List<ThemesDto> getAll();
    void save(Themes theme);
    void delete(Long id);
}
