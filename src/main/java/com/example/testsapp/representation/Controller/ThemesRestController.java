package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Entity.Themes;
import com.example.testsapp.representation.DTO.ThemesDto;
import com.example.testsapp.service.ThemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Themes")
public class ThemesRestController {

    @Autowired
    private ThemesService themesService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ThemesDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        ThemesDto themesDto = this.themesService.getById(id);

        if (themesDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(themesDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ThemesDto>> getAll()
    {
        List<ThemesDto> list = this.themesService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ThemesDto> post(@RequestBody ThemesDto themesDto)
    {
        if (themesDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.themesService.save(themesDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ThemesDto> delete(@PathVariable Long id)
    {
        ThemesDto themesDto = this.themesService.getById(id);
        if (themesDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.themesService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<ThemesDto> update(@RequestBody @Validated ThemesDto themesDto, UriComponentsBuilder builder)
    {
        if(themesDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.themesService.save(themesDto.toEntity());
        return ResponseEntity.ok().build();
    }
}
