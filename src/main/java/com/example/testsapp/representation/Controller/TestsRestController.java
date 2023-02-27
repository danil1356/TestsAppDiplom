package com.example.testsapp.representation.Controller;

import com.example.testsapp.representation.DTO.TestsDto;
import com.example.testsapp.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/Tests")
public class TestsRestController {

    @Autowired
    private TestsService testsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TestsDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        TestsDto testsDto = this.testsService.getById(id);

        if (testsDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(testsDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<TestsDto>> getAll()
    {
        List<TestsDto> list = this.testsService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TestsDto> post(@RequestBody TestsDto testsDto)
    {
        if (testsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.testsService.save(testsDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TestsDto> delete(@PathVariable Long id)
    {
        TestsDto testsDto = this.testsService.getById(id);
        if (testsDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.testsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<TestsDto> update(@RequestBody @Validated TestsDto testsDto, UriComponentsBuilder builder)
    {
        if(testsDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.testsService.save(testsDto.toEntity());
        return ResponseEntity.ok().build();
    }

}
