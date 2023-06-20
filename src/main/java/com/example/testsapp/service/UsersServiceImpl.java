package com.example.testsapp.service;

import com.example.testsapp.data.Entity.Groups;
import com.example.testsapp.data.Entity.Roles;
import com.example.testsapp.data.Entity.Status;
import com.example.testsapp.data.Entity.Users;
import com.example.testsapp.data.Repository.GroupsRepository;
import com.example.testsapp.data.Repository.RolesRepository;
import com.example.testsapp.data.Repository.UsersRepository;
import com.example.testsapp.representation.DTO.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService{

    final GroupsRepository groupsRepository;
    final UsersRepository usersRepository;
    final RolesRepository rolesRepository;
    final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsersServiceImpl(GroupsRepository groupsRepository, UsersRepository usersRepository, RolesRepository rolesRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.groupsRepository = groupsRepository;
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UsersDto getById(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        if (users.isEmpty()) {
            return null;
        }
        return UsersDto.toDto(users.get());
    }

    @Override
    public List<UsersDto> getAll() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map(UsersDto::toDto).collect(Collectors.toList());
    }

    @Override
    public void registration(Users user) {
        Set<Roles> rolesSet = new HashSet<>();
        rolesSet.add(rolesRepository.findByName("ROLE_User"));

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRolesSet(rolesSet);
        user.setStatus(Status.ACTIVE);

        usersRepository.save(user);
    }
    @Override
    public void registrationTeacher(Users user, Long id) {
        Set<Roles> rolesSet = new HashSet<>();
        rolesSet.add(rolesRepository.findByName("ROLE_User"));
        rolesSet.add(rolesRepository.findByName("ROLE_Student"));
        rolesSet.add(rolesRepository.findByName("ROLE_Teacher"));

        Set<Groups> groupsSet = new HashSet<>();
        groupsSet.add(groupsRepository.findById(id).get());

        user.setGroupsSet(groupsSet);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRolesSet(rolesSet);
        user.setStatus(Status.ACTIVE);

        usersRepository.save(user);
    }
    @Override
    public Users registrationStudent(Users user) {
        Set<Roles> rolesSet = new HashSet<>();
        rolesSet.add(rolesRepository.findByName("ROLE_User"));
        rolesSet.add(rolesRepository.findByName("ROLE_Student"));

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRolesSet(rolesSet);
        user.setStatus(Status.ACTIVE);

        Users users = usersRepository.save(user);
        return users;
    }

    @Override
    public void addGroup(Long userId, Long groupId){
        Set<Groups> groupsSet = new HashSet<>();
        groupsSet.add(groupsRepository.findById(groupId).get());

        Users user = usersRepository.findById(userId).get();
        user.setGroupsSet(groupsSet);
        usersRepository.save(user);
    }

    @Override
    public void update(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void realDelete(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void delete(Users user) {
        user.setStatus(Status.DELETED);
        usersRepository.save(user);
    }

    @Override
    public Users findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }
}
