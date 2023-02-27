package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Themes;
import com.example.testsapp.data.Repository.ThemesRepository;
import com.example.testsapp.representation.DTO.ThemesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ThemesServiceImpl implements ThemesService{

    @Autowired
    ThemesRepository themesRepository;

    @Override
    public ThemesDto getById(Long id) {
        Optional<Themes> themes = themesRepository.findById(id);
        if (themes.isEmpty()) {
            return null;
        }
        return ThemesDto.toDto(themes.get());
    }

    @Override
    public List<ThemesDto> getAll() {
        List<Themes> themes = themesRepository.findAll();
        return themes.stream().map(ThemesDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(Themes theme) {
        themesRepository.save(theme);
    }

    @Override
    public void delete(Long id) {
        themesRepository.deleteById(id);
    }
}
