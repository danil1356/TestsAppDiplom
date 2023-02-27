package com.example.testsapp.representation.Controller;

import com.example.testsapp.representation.DTO.UsersDto;
import com.example.testsapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminRestController {

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
}
