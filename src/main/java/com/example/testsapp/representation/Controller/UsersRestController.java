package com.example.testsapp.representation.Controller;

import com.example.testsapp.representation.DTO.UsersDto;
import com.example.testsapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Users")
public class UsersRestController {

    @Autowired
    private UsersService usersService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsersDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        UsersDto usersDto = this.usersService.getById(id);

        if (usersDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usersDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UsersDto>> getAll()
    {
        List<UsersDto> list = this.usersService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UsersDto> registration(@RequestBody UsersDto usersDto)
    {
        if (usersDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.usersService.registration(usersDto.toEntity());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsersDto> delete(@PathVariable Long id)
    {
        UsersDto usersDto = this.usersService.getById(id);
        if (usersDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.usersService.realDelete(id);
        return ResponseEntity.ok().build();
    }

    // TODO: 07.02.2023 идет сброс ролей
    @RequestMapping(value = "/softDelete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsersDto> softDelete(@PathVariable Long id)
    {
        UsersDto usersDto = this.usersService.getById(id);
        if (usersDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.usersService.delete(usersDto.toEntity());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<UsersDto> update(@RequestBody @Validated UsersDto usersDto, UriComponentsBuilder builder)
    {
        if(usersDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.usersService.update(usersDto.toEntity());
        return ResponseEntity.ok().build();
    }

}
