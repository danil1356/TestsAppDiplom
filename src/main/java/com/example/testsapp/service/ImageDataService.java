package com.example.testsapp.service;

import com.example.testsapp.data.Entity.ImageData;
import com.example.testsapp.representation.DTO.ImageDataDto;

import java.util.List;
import java.util.Optional;

public interface ImageDataService {
    ImageDataDto getById(Long id);
    List<ImageDataDto> getAll();
    void save(ImageData image);
    void delete(Long id);
}
