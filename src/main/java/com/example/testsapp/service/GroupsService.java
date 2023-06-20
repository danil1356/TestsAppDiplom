package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Groups;
import com.example.testsapp.representation.DTO.GroupsDTO;

import java.util.List;

public interface GroupsService {

    GroupsDTO getById(Long id);
    List<GroupsDTO> getAll();
    Groups save(Groups groups);
    void delete(Long id);
}
