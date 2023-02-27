package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.Statistics;
import com.example.testsapp.data.Entity.Status;
import com.example.testsapp.data.Entity.Tests;
import com.example.testsapp.data.Entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.example.testsapp.data.Entity.Users} entity
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersDto implements Serializable {
    private final Long id;
    private final String login;
    private final String password;
    private final String name;
    private final String second_name;
    private final String mail;

    private final Status status;

    private final Set<RolesDto> rolesDTOSet;
    private final Set<TestsDto> testsSet;
    private final Set<StatisticsDto> statistic;

    public Users toEntity()
    {
        return new Users(
                this.id,
                this.login,
                this.password,
                this.name,
                this.second_name,
                this.mail,
                this.status
        );
    }

    public static UsersDto toDto(Users user)
    {
        return new UsersDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSecond_name(),
                user.getMail(),

                user.getStatus(),

                user.getRolesSet().stream().map(RolesDto::toDto).collect(Collectors.toSet()),
                user.getTestsSet().stream().map(TestsDto::toDto).collect(Collectors.toSet()),
                user.getStatistic().stream().map(StatisticsDto::toDto).collect(Collectors.toSet())
        );
    }
}