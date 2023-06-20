package com.example.testsapp.representation.DTO;

import com.example.testsapp.data.Entity.Groups;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Data
//todo свой сериализатор
//@JsonSerialize(using = MyGroupSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupsDTO implements Serializable {
    private final Long id;
    private final String name;

    private final Set<UsersDto> usersDtos;

    public Groups toEntity(){
      return new Groups(
              this.id,
              this.name
      );
    };


    public static GroupsDTO toDto(Groups groups){
        return new GroupsDTO(
                groups.getId(),
                groups.getName(),
                groups.getUsers() == null? null : groups.getUsers().stream().map(UsersDto::toDto).collect(Collectors.toSet())
        );
    }
}
