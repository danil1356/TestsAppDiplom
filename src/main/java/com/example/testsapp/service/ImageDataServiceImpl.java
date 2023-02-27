package com.example.testsapp.service;

import com.example.testsapp.data.Entity.ImageData;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.ImageDataRepository;
import com.example.testsapp.representation.DTO.ImageDataDto;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageDataServiceImpl implements ImageDataService{

    @Autowired
    ImageDataRepository imageDataRepository;

    @Override
    public ImageDataDto getById(Long id) {
        Optional<ImageData> imageData = imageDataRepository.findById(id);
        if (imageData.isEmpty()) {
            return null;
        }
        return ImageDataDto.toDto(imageData.get());
    }

    @Override
    public List<ImageDataDto> getAll() {
        List<ImageData> imageData = imageDataRepository.findAll();
        return imageData.stream().map(ImageDataDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(ImageData image) {
        imageDataRepository.save(image);
    }

    @Override
    public void delete(Long id) {
        imageDataRepository.deleteById(id);
    }
}
