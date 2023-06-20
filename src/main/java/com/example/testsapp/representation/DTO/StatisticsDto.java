package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.data.Entity.Tests;
import com.example.testsapp.data.Entity.Users;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.Statistics} entity
 */
@Data
public class StatisticsDto implements Serializable {
    private final Long id;
    private final Long test_result;
    private final Long tests_id;
    private final Long user_id;
    private final String pass_name;



    public Statistics toEntity()
    {
        return new Statistics(
                this.id,
                this.test_result,
                new Tests(this.tests_id),
                new Users(this.user_id),
                this.pass_name
        );
    }

    public static StatisticsDto toDto(Statistics statistics)
    {
        return new StatisticsDto(
                statistics.getId(),
                statistics.getTest_result(),
                statistics.getTest().getId(),
                statistics.getUser().getId(),
                statistics.getPass_name()
        );
    }
}