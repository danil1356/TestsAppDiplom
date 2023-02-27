package com.example.testsapp.service;


import com.example.testsapp.data.Entity.SubTheme;
import com.example.testsapp.representation.DTO.SubThemeDto;

import java.util.List;
import java.util.Optional;

public interface SubThemeService {
    SubThemeDto getById(Long id);
    List<SubThemeDto> getAll();
    void save(SubTheme subTheme);
    void delete(Long id);
}
