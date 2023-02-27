package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Themes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemesRepository extends JpaRepository<Themes, Long> {
}