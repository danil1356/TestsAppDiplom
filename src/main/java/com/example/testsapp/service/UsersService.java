package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.representation.DTO.UsersDto;

import java.util.List;

public interface UsersService {
    UsersDto getById(Long id);
    List<UsersDto> getAll();
    void registration(Users user);
    void update(Users user);
    void realDelete(Long id);
    void delete(Users user);
    Users findByLogin(String login);


    void registrationTeacher(Users user, Long id);
    Users registrationStudent(Users user);
    void addGroup(Long userId, Long groupId);
}
