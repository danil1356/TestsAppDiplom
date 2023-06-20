package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Groups;
import com.example.testsapp.data.Entity.Roles;
import com.example.testsapp.data.Repository.GroupsRepository;
import com.example.testsapp.representation.DTO.GroupsDTO;
import com.example.testsapp.representation.DTO.RolesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    @Override
    public GroupsDTO getById(Long id) {
        Optional<Groups> groups = groupsRepository.findById(id);
        if (groups.isEmpty()) {
            return null;
        }
        return GroupsDTO.toDto(groups.get());
    }

    @Override
    public List<GroupsDTO> getAll() {
        List<Groups> groups = groupsRepository.findAll();
        return groups.stream().map(GroupsDTO::toDto).collect(Collectors.toList());
    }

    @Override
    public Groups save(Groups groups) {
        Groups groups1 = groupsRepository.save(groups);
        return groups1;
    }

    @Override
    public void delete(Long id) {
        groupsRepository.deleteById(id);
    }
}
