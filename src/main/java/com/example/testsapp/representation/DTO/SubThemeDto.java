package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.SubTheme;
import com.example.testsapp.data.Entity.Themes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.SubTheme} entity
 */
@Data
public class SubThemeDto implements Serializable {
    private final Long id;
    private final String name;
    private final Long theme_id;

    // TODO: 06.02.2023 expand
    private ThemesDto themesDto;

    private final Set<TestsDto> testsSet;


    public SubTheme toEntity()
    {
        return new SubTheme(
                this.id,
                this.name,
                new Themes(this.theme_id)
        );
    }

    public static SubThemeDto toDto(SubTheme subTheme)
    {
        return new SubThemeDto(
                subTheme.getId(),
                subTheme.getName(),
                subTheme.getTheme().getId(),
                subTheme.getTestsSet().stream().map(TestsDto::toDto).collect(Collectors.toSet())
        );
    }
}