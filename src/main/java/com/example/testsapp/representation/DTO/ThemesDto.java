package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.SubTheme;
import com.example.testsapp.data.Entity.Tests;
import com.example.testsapp.data.Entity.Themes;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.Themes} entity
 */
@Data
public class ThemesDto implements Serializable {
    private final Long id;
    private final String name;
    private final Set<SubThemeDto> subThemeSet;
    private final Set<TestsDto> testsSet;


    public Themes toEntity()
    {
        return new Themes(
                this.id,
                this.name
        );
    }

    public static ThemesDto toDto(Themes themes)
    {
        return new ThemesDto(
                themes.getId(),
                themes.getName(),
                themes.getSubThemeSet().stream().map(SubThemeDto::toDto).collect(Collectors.toSet()),
                themes.getTestsSet().stream().map(TestsDto::toDto).collect(Collectors.toSet())
        );
    }
}