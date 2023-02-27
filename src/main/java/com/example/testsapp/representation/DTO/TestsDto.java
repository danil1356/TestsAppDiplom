package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.SubTheme;
import com.example.testsapp.data.Entity.Tests;
import com.example.testsapp.data.Entity.Themes;
import com.example.testsapp.data.Entity.Users;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.Tests} entity
 */
@Data
public class TestsDto implements Serializable {
    private final Long id;
    private final String name;
    private final Time execution_time;
    private final String author;

    private final Long user_id;
    //private final UsersDto user;
    private final Long theme_id;
    //private final ThemesDto theme;
    private final Long subthemes_id;
    //private final SubThemeDto subTheme;

    private final Set<QuestionsDto> questionsSet;
    private final Set<StatisticsDto> statisticsSet;


    public Tests toEntity()
    {
        return new Tests(
                this.id,
                this.name,
                this.execution_time,
                this.author,
                new Users(this.user_id),
                new Themes(this.theme_id),
                new SubTheme(this.subthemes_id)
        );
    }

    public static TestsDto toDto(Tests tests)
    {
        return new TestsDto(
                tests.getId(),
                tests.getName(),
                tests.getExecution_time(),
                tests.getAuthor(),
                tests.getUser().getId(),
                tests.getTheme().getId(),
                tests.getSubTheme().getId(),
                tests.getQuestionsSet().stream().map(QuestionsDto::toDto).collect(Collectors.toSet()),
                tests.getStatisticsSet().stream().map(StatisticsDto::toDto).collect(Collectors.toSet())
        );
    }
}