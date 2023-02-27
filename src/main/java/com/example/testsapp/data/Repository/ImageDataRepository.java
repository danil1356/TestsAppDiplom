package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
}