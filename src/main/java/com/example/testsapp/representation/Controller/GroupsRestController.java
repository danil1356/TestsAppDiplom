package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Entity.Groups;
import com.example.testsapp.representation.DTO.GroupsDTO;
import com.example.testsapp.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Groups")
public class GroupsRestController {

    @Autowired
    private GroupsService groupsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GroupsDTO> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        GroupsDTO groupsDTO = this.groupsService.getById(id);

        if (groupsDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(groupsDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<GroupsDTO>> getAll()
    {
        List<GroupsDTO> list = this.groupsService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GroupsDTO> post(@RequestBody GroupsDTO groupsDTO)
    {
        if (groupsDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        Groups groups = this.groupsService.save(groupsDTO.toEntity());
        return ResponseEntity.ok(GroupsDTO.toDto(groups));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GroupsDTO> delete(@PathVariable Long id)
    {
        GroupsDTO groupsDTO = this.groupsService.getById(id);
        if (groupsDTO == null) {
            return ResponseEntity.notFound().build();
        }

        this.groupsService.delete(id);
        return ResponseEntity.ok(groupsDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<GroupsDTO> update(@RequestBody @Validated GroupsDTO groupsDTO, UriComponentsBuilder builder)
    {
        if(groupsDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        this.groupsService.save(groupsDTO.toEntity());
        return ResponseEntity.ok().build();
    }
}
