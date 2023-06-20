package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Tests;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.TestsRepository;
import com.example.testsapp.data.Repository.UsersRepository;
import com.example.testsapp.representation.DTO.TestsDto;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestsServiceImpl implements TestsService{

    final TestsRepository testsRepository;
    final UsersRepository usersRepository;

    @Autowired
    public TestsServiceImpl(TestsRepository testsRepository, UsersRepository usersRepository) {
        this.testsRepository = testsRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public TestsDto getById(Long id) {
        Optional<Tests> tests = testsRepository.findById(id);
        if (tests.isEmpty()) {
            return null;
        }
        return TestsDto.toDto(tests.get());
    }

    @Override
    public List<TestsDto> getAll() {
        List<Tests> tests = testsRepository.findAll();
        return tests.stream().map(TestsDto::toDto).collect(Collectors.toList());
    }

    // TODO: 29.05.2023 Делается от пользователя так как, бесконенчный вложенный JSON. Написать свой сериализатор
    @Override
    public Tests save(Tests test) {
        Tests tests = testsRepository.save(test);
        return tests;
    }

    @Override
    public void delete(Long id) {
        testsRepository.deleteById(id);
    }

    // TODO: 29.05.2023 Делается от пользователя так как, бесконенчный вложенный JSON. Написать свой сериализатор
    @Override
    public void addUser(Long userId, Long testId){
        Users users = usersRepository.findById(userId).get();
        Set<Tests> testsSet = users.getTestsSet()==null? new HashSet<>(): users.getTestsSet();

        testsSet.add(testsRepository.findById(testId).get());

        users.setTestsSet(testsSet);
        usersRepository.save(users);
    }

    @Override
    public Tests saveWithUser(Tests test, Long userId) {
        Tests tests = testsRepository.save(test);

        Users users = usersRepository.findById(userId).get();
        Set<Tests> testsSet = users.getTestsSet()==null? new HashSet<>(): users.getTestsSet();
        testsSet.add(tests);
        users.setTestsSet(testsSet);
        usersRepository.save(users);


        return tests;
    }
}
