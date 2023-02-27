package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Entity.Roles;
import com.example.testsapp.representation.DTO.RolesDto;
import com.example.testsapp.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping(value = "/Roles")
public class RolesRestController {

    @Autowired
    private RolesService rolesService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RolesDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        RolesDto rolesDto = this.rolesService.getById(id);

        if (rolesDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rolesDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<RolesDto>> getAll()
    {
        List<RolesDto> list = this.rolesService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RolesDto> post(@RequestBody RolesDto rolesDto)
    {
        if (rolesDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.rolesService.save(rolesDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RolesDto> delete(@PathVariable Long id)
    {
        RolesDto rolesDto = this.rolesService.getById(id);
        if (rolesDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.rolesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<RolesDto> update(@RequestBody @Validated RolesDto rolesDto, UriComponentsBuilder builder)
    {
        if(rolesDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.rolesService.save(rolesDto.toEntity());
        return ResponseEntity.ok().build();
    }
}
