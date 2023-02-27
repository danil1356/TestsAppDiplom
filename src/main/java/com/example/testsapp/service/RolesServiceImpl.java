package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Roles;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.RolesRepository;
import com.example.testsapp.representation.DTO.RolesDto;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public RolesDto getById(Long id) {
        Optional<Roles> roles = rolesRepository.findById(id);
        if (roles.isEmpty()) {
            return null;
        }
        return RolesDto.toDto(roles.get());
    }

    @Override
    public List<RolesDto> getAll() {
        List<Roles> roles = rolesRepository.findAll();
        return roles.stream().map(RolesDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void save(Roles role) {
        rolesRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }
}
