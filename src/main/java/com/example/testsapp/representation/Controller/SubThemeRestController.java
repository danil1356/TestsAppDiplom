package com.example.testsapp.representation.Controller;

import com.example.testsapp.data.Repository.ThemesRepository;
import com.example.testsapp.representation.DTO.SubThemeDto;
import com.example.testsapp.representation.DTO.ThemesDto;
import com.example.testsapp.service.SubThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/SubTheme")
public class SubThemeRestController {

    @Autowired
    private SubThemeService subThemeService;
    @Autowired
    private ThemesRepository themesRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubThemeDto> get(@PathVariable Long id,
                                           @RequestParam(required = false) Object expand)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        // TODO: 06.02.2023
        SubThemeDto subThemeDto = this.subThemeService.getById(id);
        if(expand!= null)
        {
            subThemeDto.setThemesDto(ThemesDto.toDto(themesRepository.getById(subThemeDto.getTheme_id())));
        }

        if (subThemeDto == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(subThemeDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<SubThemeDto>> getAll()
    {
        List<SubThemeDto> list = this.subThemeService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SubThemeDto> post(@RequestBody SubThemeDto subThemeDto)
    {
        if (subThemeDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.subThemeService.save(subThemeDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SubThemeDto> delete(@PathVariable Long id)
    {
        SubThemeDto subThemeDto = this.subThemeService.getById(id);
        if (subThemeDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.subThemeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<SubThemeDto> update(@RequestBody @Validated SubThemeDto subThemeDto, UriComponentsBuilder builder)
    {
        if(subThemeDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.subThemeService.save(subThemeDto.toEntity());
        return ResponseEntity.ok().build();
    }
}
