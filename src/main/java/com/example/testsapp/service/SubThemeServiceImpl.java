package com.example.testsapp.service;

import com.example.testsapp.data.Entity.SubTheme;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.SubThemeRepository;
import com.example.testsapp.representation.DTO.SubThemeDto;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubThemeServiceImpl implements SubThemeService{

    @Autowired
    SubThemeRepository subThemeRepository;

    @Override
    public SubThemeDto getById(Long id) {
        Optional<SubTheme> subTheme = subThemeRepository.findById(id);
        if (subTheme.isEmpty()) {
            return null;
        }
        return SubThemeDto.toDto(subTheme.get());
    }

    @Override
    public List<SubThemeDto> getAll() {
        List<SubTheme> subThemes = subThemeRepository.findAll();
        return subThemes.stream().map(SubThemeDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(SubTheme subTheme) {
        subThemeRepository.save(subTheme);
    }

    @Override
    public void delete(Long id) {
        subThemeRepository.deleteById(id);
    }
}
